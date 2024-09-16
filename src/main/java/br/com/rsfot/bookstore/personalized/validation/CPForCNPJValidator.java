package br.com.rsfot.bookstore.personalized.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CPForCNPJValidator implements ConstraintValidator<CPFOrCNPJ, String> {
    private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

    @Override
    public void initialize(CPFOrCNPJ constraintAnnotation) {
        this.cpfValidator = new CPFValidator();
        this.cnpjValidator = new CNPJValidator();
    }

    @Override
    public boolean isValid(String document, ConstraintValidatorContext context) {
        if (document == null || document.isEmpty() || document.isBlank()) {
            return false;
        }
        return cpfValidator.isValid(document, context) || cnpjValidator.isValid(document, context);
    }
}