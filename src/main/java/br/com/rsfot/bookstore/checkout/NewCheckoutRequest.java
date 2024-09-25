package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.personalized.validation.CPFOrCNPJ;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewCheckoutRequest(
        @NotNull
        @Email
        String email,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        @CPFOrCNPJ
        String document,
        @NotBlank
        String phone,
        @NotNull
        @Valid
        NewCheckoutAddressRequest newCheckoutAddressRequest,
        @NotNull
        @Valid
        NewOrderRequest newOrderRequest
) {

    public String getCountryName() {
        return newCheckoutAddressRequest.country();
    }

    public String getStateName() {
        return newCheckoutAddressRequest.state();
    }
}
