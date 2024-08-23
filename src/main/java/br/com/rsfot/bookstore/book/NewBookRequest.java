package br.com.rsfot.bookstore.book;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NewBookRequest(
        String title,
        String summary,
        String tableOfContent,
        BigDecimal price,
        int numberOfPages,
        String isbn,
        LocalDate publicationDate,
        String categoryName,
        String emailAuthor
) {}
