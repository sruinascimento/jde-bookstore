package br.com.rsfot.bookstore.country;

import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public record NewCountryRequest(@NotBlank @UniqueValue(fieldName = "name", domainClass = Country.class) String name) {

        public Country toModel() {
            return new Country(name);
        }
}
