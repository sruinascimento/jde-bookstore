package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.category.Category;
import br.com.rsfot.bookstore.personalized.validation.ValueExists;
import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        @Future
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt_BR")
        LocalDateTime publicationDate,
        @NotBlank
        @ValueExists(fieldName = "name", domainClass = Category.class)
        String categoryName,
        @NotBlank
        @Email
        @ValueExists(fieldName = "email", domainClass = Author.class)
        String emailAuthor) {

        public Book toModel(Category category, Author author) {
                return new Book(title(),
                        summary(),
                        tableOfContent(),
                        price(),
                        isbn(),
                        publicationDate(),
                        category,
                        author);
        }
}
