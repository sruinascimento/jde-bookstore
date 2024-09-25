package br.com.rsfot.bookstore.checkout;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String document;

    @Embedded
    private Address address;

    @Transient
    private BigDecimal amount;

    @OneToMany(mappedBy = "cart_id", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Set<Order> orders = new HashSet<>();

    @Deprecated
    public Cart() {
    }

    public Cart(String firstName, String lastName, String document, Address address, BigDecimal amount, Set<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.amount = amount;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public Address getAddress() {
        return address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
