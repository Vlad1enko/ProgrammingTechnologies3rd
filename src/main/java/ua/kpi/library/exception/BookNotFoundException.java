package ua.kpi.library.exception;

import ua.kpi.library.model.Author;
import ua.kpi.library.model.BookGenreEnum;

import java.util.NoSuchElementException;

public class BookNotFoundException extends NoSuchElementException {
    public BookNotFoundException(String title) {
        super("No book with title " + title + " found");
    }
    public BookNotFoundException(Integer id) {
        super("No book with id " + id + " found");
    }
    public BookNotFoundException(Author author) {
        super("No books of " + author.getName() + " " + author.getSurname() + " found");
    }
    public BookNotFoundException(BookGenreEnum genre) {
        super("No similar books of genre " + genre + " found");
    }
}
