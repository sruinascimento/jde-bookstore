package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.author.AuthorRepository;
import br.com.rsfot.bookstore.category.Category;
import br.com.rsfot.bookstore.category.CategoryRepository;
import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record NewBookRequest(
        @NotBlank
        @UniqueValue(fieldName = "title", domainClass = Book.class)
        String title,
        @NotBlank
        @Size(max = 500)
        String summary,
        String tableOfContent,
        @NotNull
        @Min(20)
        BigDecimal price,
        @NotNull
        @Min(100)
        int numberOfPages,
        @NotBlank
        @UniqueValue(fieldName = "isbn", domainClass = Book.class)
        String isbn,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime publicationDate,
        @NotBlank
        String categoryName,
        @NotBlank
        @Email
        String emailAuthor
) {

        public Book toEntity(Category category, Author author) {
                return new Book(title,
                        summary,
                        tableOfContent,
                        price,
                        numberOfPages,
                        isbn,
                        publicationDate,
                        category,
                        author);
        }

}
