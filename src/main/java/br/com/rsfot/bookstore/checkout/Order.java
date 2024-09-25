package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.book.Book;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long ig;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Deprecated
    public Order() {

    }

    public Order(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Long getIg() {
        return ig;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
}
