package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.category.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record NewBookResponse(
        Long id,
        String title,
        String summary,
        String tableOfContent,
        BigDecimal price,
        int numberOfPages,
        String isbn,
        String publicationDate,
        String category,
        String author) {
    
    public NewBookResponse(Book book) {
        this(
                book.getId(),
                book.getTitle(),
                book.getSummary(),
                book.getTableOfContent(),
                book.getPrice(),
                book.getNumberOfPages(),
                book.getIsbn(),
                book.getPublicationDateAsBrazilianFormat(),
                book.getCategoryName(),
                book.getAuthorName()
        );
    }
}
