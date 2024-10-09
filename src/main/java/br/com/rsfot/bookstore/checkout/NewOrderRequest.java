package br.com.rsfot.bookstore.checkout;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Set;

public record NewOrderRequest(
        @NotNull
        @Positive
        BigDecimal amount,
        @Valid
        @Size(min = 1)
        Set<OrderItemRequest> items
) {
}
