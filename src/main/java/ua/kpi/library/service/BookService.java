package ua.kpi.library.service;

import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookByTitle(String title);
    public Book createBook(Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre);
    public Book getBookById(long id);
    public Book updateBookById(Book book);
}
