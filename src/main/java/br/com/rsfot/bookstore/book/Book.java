package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(length = 500, nullable = false)
    private String summary;

    @Column(name = "table_of_content", columnDefinition = "TEXT")
    private String tableOfContent;

    @Column(nullable = false)
    @Min(20)
    private BigDecimal price;

    @Column(nullable = false, name = "number_of_pages")
    @Min(100)
    private int numberOfPages;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private Author author;

    /**
     * eyes only hibernate
     */
    @Deprecated
    public Book() {
    }

    public Book(
            @NotBlank String title,
            @NotBlank @Size(max = 500) String summary,
            @NotBlank String tableOfContent,
            @Min(20) @NotNull BigDecimal price,
            @NotNull @Min(100) int numberOfPages,
            @NotBlank String isbn,
            @Future LocalDateTime publicationDate,
            @NotNull Category category,
            @NotNull Author author) {
        this.title = title;
        this.summary = summary;
        this.tableOfContent = tableOfContent;
        this.price = price;
        this.numberOfPages = numberOfPages;
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

    public @Min(20) BigDecimal getPrice() {
        return price;
    }

    @Min(100)
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationDateAsBrazilianFormat() {
        return publicationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.of("pt_BR")));
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryName() {
        return category.getName();
    }

    public Author getAuthor() {
        return author;
    }

    public String getAuthorName() {
        return author.getName();
    }
}
