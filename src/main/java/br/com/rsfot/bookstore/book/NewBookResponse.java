package br.com.rsfot.bookstore.book;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record NewBookResponse(
        String title,
        String summary,
        String tableOfContent,
        BigDecimal price,
        int numberOfPages,
        String isbn,
        String publicationDate,
        String categoryName,
        String author) {

    public NewBookResponse(Book book) {
        this(
                book.getTitle(),
                book.getSummary(),
                book.getTableOfContent(),
                book.getPrice(),
                book.getNumberOfPages(),
                book.getIsbn(),
                book.getPublicationDateAsBrFormat(),
                book.getCategoryName(),
                book.getAuthorName()
        );
    }


}
