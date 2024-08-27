package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String summary;

    @Column(name = "table_of_content")
    private String tableOfContent;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Future
    @Column(name = "publication_date", nullable = false)
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    /**
     * eye only hibernate
     */
    @Deprecated
    public Book() {
    }

    public Book(String title,
                String summary,
                String tableOfContent,
                BigDecimal price,
                String isbn,
                LocalDateTime publicationDate,
                Category category,
                Author author) {
        this.title = title;
        this.summary = summary;
        this.tableOfContent = tableOfContent;
        this.price = price;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getTableOfContent() {
        return tableOfContent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public @Future LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", tableOfContent='" + tableOfContent + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
}
