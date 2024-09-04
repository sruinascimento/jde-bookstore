package br.com.rsfot.bookstore.book;

import br.com.rsfot.bookstore.author.AuthorDetailsResponse;


public record BookDetailsResponse(
        String bookTitle,
        String summary,
        String tableOfContent,
        int numberOfPages,
        String isbn,
        String publicationDate,
        String category,
        AuthorDetailsResponse author) {

    public BookDetailsResponse(Book book) {
        this(book.getTitle(),
                book.getSummary(),
                book.getTableOfContent(),
                book.getNumberOfPages(),
                book.getIsbn(),
                book.getPublicationDateAsBrazilianFormat(),
                book.getCategoryName(),
                new AuthorDetailsResponse(book.getAuthor()));
    }
}
