package br.com.rsfot.bookstore.author;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/author")
    @Transactional
    public ResponseEntity<NewAuthorResponse> create(@Valid @RequestBody NewAuthorRequest newAuthorRequest) {
        Author newAuthor = newAuthorRequest.toEntity();
        authorRepository.save(newAuthor);
        return ResponseEntity.ok(new NewAuthorResponse(newAuthor));
    }

}
