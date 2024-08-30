package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.author.AuthorRepository;
import br.com.rsfot.bookstore.category.Category;
import br.com.rsfot.bookstore.category.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public BookController(AuthorRepository authorRepository,
                          CategoryRepository categoryRepository,
                          BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    public ResponseEntity create(@Valid @RequestBody NewBookRequest newBookRequest) {
        Category category = categoryRepository.findByName(newBookRequest.categoryName())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with name %s".formatted(newBookRequest.categoryName())));
        Author author = authorRepository.findByEmail(newBookRequest.emailAuthor())
                .orElseThrow(() -> new IllegalArgumentException("Author not found with email %s".formatted(newBookRequest.emailAuthor())));


        Book newBook = newBookRequest.toModel(category, author);
        bookRepository.save(newBook);

        return ResponseEntity.ok(new NewBookResponse(newBook));
    }
}
