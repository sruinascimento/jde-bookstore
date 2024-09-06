package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.author.AuthorRepository;
import br.com.rsfot.bookstore.category.Category;
import br.com.rsfot.bookstore.category.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody NewBookRequest newBookRequest) {
        Category category = categoryRepository.findByName(newBookRequest.categoryName())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with name: " + newBookRequest.categoryName()));
        Author author = authorRepository.findByEmail(newBookRequest.emailAuthor())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with email: " + newBookRequest.emailAuthor()));


        Book newBook = newBookRequest.toEntity(category, author);

        bookRepository.save(newBook);

        return ResponseEntity.ok(new NewBookResponse(newBook));
    }

    @GetMapping("/book")
    public ResponseEntity<List<AllBooksResponse>> retrieveAllBooks() {
        List<AllBooksResponse> books = bookRepository.findAll().stream()
                .map(AllBooksResponse::new)
                .toList();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDetailsResponse> retrieveDetailsOfBook(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        return ResponseEntity.ok(new BookDetailsResponse(book));
    }

}
