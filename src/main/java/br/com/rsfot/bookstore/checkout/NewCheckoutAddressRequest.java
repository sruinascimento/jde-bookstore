package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.country.Country;
import br.com.rsfot.bookstore.personalized.validation.ExistsValue;
import br.com.rsfot.bookstore.state.State;
import jakarta.validation.constraints.NotBlank;

public record NewCheckoutAddressRequest(
        @NotBlank
        String address,
        @NotBlank
        String complement,
        @NotBlank
        String city,
        @ExistsValue(domainClass = State.class, fieldName = "name")
        String state,
        @NotBlank
        @ExistsValue(domainClass = Country.class, fieldName = "name")
        String country,
        @NotBlank
        String zipCode

) {
}
