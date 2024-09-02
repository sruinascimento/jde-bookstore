package br.com.rsfot.bookstore.book;

public record AllBooksResponse(Long id, String bookTitlemn) {
    public AllBooksResponse (Book book) {
        this(book.getId(), book.getTitle());
    }
}
