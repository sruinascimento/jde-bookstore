package br.com.rsfot.bookstore.checkout;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public class CheckoutController {

    public void create(@Valid @RequestBody NewCheckoutRequest newCheckoutRequest) {

    }
}
