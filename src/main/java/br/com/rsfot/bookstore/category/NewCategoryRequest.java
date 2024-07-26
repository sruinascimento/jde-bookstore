package br.com.rsfot.bookstore.category;

import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public record NewCategoryRequest(
        @NotBlank
        @UniqueValue(fieldName = "name", domainClass = Category.class)
        String name) {

    public Category toEntity() {
        return new Category(name);
    }
}
