package br.com.rsfot.bookstore.state;

import br.com.rsfot.bookstore.country.Country;
import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public record NewStateRequest(
    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = State.class)
    String stateName,
    @NotBlank
    String countryName) {
    public State toModel(Country country) {
        return new State(stateName(), country);
    }
}
