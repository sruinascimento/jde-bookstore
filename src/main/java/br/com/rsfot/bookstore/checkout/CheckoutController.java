package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.country.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CheckoutController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping("/checkout")
    public String create(@Valid @RequestBody NewCheckoutRequest newCheckoutRequest) {

        Query query = entityManager.createQuery("select name from Country where name = :countryName");
        query.setParameter("countryName", newCheckoutRequest.getCountryName());
        try {
            Country country = (Country) query.getSingleResult();
        } catch (NoResultException exception) {
            throw new IllegalArgumentException("The country %s does not exists ".formatted(newCheckoutRequest.getCountryName()));
        }
        return newCheckoutRequest.toString();
    }
}
