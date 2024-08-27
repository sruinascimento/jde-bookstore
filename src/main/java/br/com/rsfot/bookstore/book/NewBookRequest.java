package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        LocalDate publicationDate,
        @NotBlank
        String categoryName,
        @NotBlank
        @Email
        String emailAuthor
) {}
