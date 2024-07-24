package br.com.rsfot.bookstore.author;

import br.com.rsfot.bookstore.personalized.validation.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewAuthorRequest(
        @NotBlank
        String name,
        @Email
        @NotNull
        @UniqueValue(fieldName = "email", domainClass = Author.class)
        String email,
        @Size(max = 400)
        @NotBlank
        String description) {

    public Author toEntity() {
        return new Author(name, email, description);
    }
}
