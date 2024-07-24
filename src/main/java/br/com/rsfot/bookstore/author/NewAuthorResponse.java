package br.com.rsfot.bookstore.author;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record NewAuthorResponse(
        String name,
        String email,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
        LocalDateTime createdAt) {
    public NewAuthorResponse(Author author) {
        this(author.getName(), author.getEmail(), author.getDescription(), author.getCreatedAt());
    }
}
