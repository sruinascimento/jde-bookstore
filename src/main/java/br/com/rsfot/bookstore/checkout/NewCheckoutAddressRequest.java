package br.com.rsfot.bookstore.checkout;

import jakarta.validation.constraints.NotBlank;

public record NewCheckoutAddressRequest(
        @NotBlank
        String address,
        @NotBlank
        String complement,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String country,
        @NotBlank
        String zipCode

) {
}
