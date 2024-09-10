package br.com.rsfot.bookstore.checkout;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NewCheckoutRequest(
        @Email
        String email,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String document,
        String phone,
        NewCheckoutAddressRequest newCheckoutAddressRequest
) {
}
