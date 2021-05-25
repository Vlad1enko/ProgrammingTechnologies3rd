package ua.kpi.library.service;

import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookByTitle(String title);
    Book createBook(Book book);
    Book getBookById(Long id);
}
