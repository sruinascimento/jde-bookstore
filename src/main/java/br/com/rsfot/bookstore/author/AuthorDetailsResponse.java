package br.com.rsfot.bookstore.author;

public record AuthorDetailsResponse(
        String name,
        String email,
        String description) {

    public AuthorDetailsResponse(Author author) {
        this(author.getName(), author.getEmail(), author.getDescription());
    }
}
