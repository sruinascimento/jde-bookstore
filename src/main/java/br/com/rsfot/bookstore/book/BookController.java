package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.author.AuthorRepository;
import br.com.rsfot.bookstore.category.Category;
import br.com.rsfot.bookstore.category.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookController(CategoryRepository categoryRepository,
                          AuthorRepository authorRepository,
                          BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    public ResponseEntity<?> create(@Valid @RequestBody NewBookRequest newBookRequest) {
        Category category = categoryRepository.findByName(newBookRequest.categoryName())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with name: " + newBookRequest.categoryName()));
        Author author = authorRepository.findByEmail(newBookRequest.emailAuthor())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with email: " + newBookRequest.emailAuthor()));


        Book newBook = newBookRequest.toEntity(category, author);

        bookRepository.save(newBook);

        return ResponseEntity.ok(new NewBookResponse(newBook));
    }
}
