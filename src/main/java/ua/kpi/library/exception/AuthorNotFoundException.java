package ua.kpi.library.exception;

import ua.kpi.library.model.Book;

import java.util.NoSuchElementException;

public class AuthorNotFoundException extends NoSuchElementException {
    public AuthorNotFoundException() {
        super("No author found");
    }
    public AuthorNotFoundException(Book book) {
        super("No author of " + book.getTitle() + " found");
    }
}
