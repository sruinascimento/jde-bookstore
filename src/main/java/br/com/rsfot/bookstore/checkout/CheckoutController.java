package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.personalized.validation.StateBelongsToCountryValidator;
import jakarta.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {
    private final StateBelongsToCountryValidator stateBelongsToCountryValidator;

    public CheckoutController(StateBelongsToCountryValidator stateBelongsToCountryValidator) {
        this.stateBelongsToCountryValidator = stateBelongsToCountryValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(stateBelongsToCountryValidator);
    }

    @PostMapping("/checkout")
    public String create(@Valid @RequestBody NewCheckoutRequest newCheckoutRequest) {
        return newCheckoutRequest.toString();
    }
}
