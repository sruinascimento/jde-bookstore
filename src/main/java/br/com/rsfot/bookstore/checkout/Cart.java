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

    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String document;

    @Embedded
    private Address address;

    private String phone;

    @Transient
    private BigDecimal amount;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Set<OrderItem> orders = new HashSet<>();

    @Deprecated
    public Cart() {
    }

    public Cart(String email,
                String firstName,
                String lastName,
                String document,
                Address address,
                String phone,
                BigDecimal amount,
                Set<OrderItem> orders) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.phone = phone;
        this.amount = amount;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
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

    public String getPhone() {
        return phone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Set<OrderItem> getOrders() {
        return orders;
    }
}
