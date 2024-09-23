package br.com.rsfot.bookstore.personalized.validation;

import br.com.rsfot.bookstore.checkout.NewCheckoutRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StateBelongsToCountryValidator implements Validator {

    @PersistenceContext
    private final EntityManager entityManager;

    public StateBelongsToCountryValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewCheckoutRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        var newCheckoutRequest = (NewCheckoutRequest) target;
        Query query = entityManager.createQuery("select 1 from State s join s.country c where s.name = :state and c.name = :country");
        query.setParameter("state", newCheckoutRequest.getStateName());
        query.setParameter("country", newCheckoutRequest.getCountryName());

        if (query.getResultList().isEmpty()) {
            errors.rejectValue("newCheckoutAddressRequest.state", null, "The state does not belong to the country");
        }

    }

}
