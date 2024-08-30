package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.category.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookBuilder {
    private String title;
    private String summary;
    private String tableOfContent;
    private BigDecimal price;
    private int numberOfPages;
    private String isbn;
    private LocalDateTime publicationDate;
    private Category category;
    private Author author;

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public BookBuilder withTableOfContent(String tableOfContent) {
        this.tableOfContent = tableOfContent;
        return this;
    }

    public BookBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BookBuilder withNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public BookBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder withPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public BookBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public BookBuilder withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Book build() {
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
