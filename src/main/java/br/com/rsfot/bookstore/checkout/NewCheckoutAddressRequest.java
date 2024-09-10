package br.com.rsfot.bookstore.checkout;

public record NewCheckoutAddressRequest(
        String address,
        String complement,
        String city,
        String state,
        String country,
        String zipCode

) {
}
