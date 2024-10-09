package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.book.Book;
import br.com.rsfot.bookstore.personalized.validation.ExistsValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequest(
        @NotNull
        @ExistsValue(domainClass = Book.class, fieldName = "id")
        Long bookId,
        @NotNull
        @Positive
        int quantity
) {
}
