package br.com.rsfot.bookstore.country;

public record NewCountryResponse(String name) {
    public NewCountryResponse(Country country) {
        this(country.getName());
    }
}
