package ua.kpi.library.service;

import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

public interface LibraryService {
    public List<Book> getBooksOfAuthor(Author author);
    public List<Book> getBooksOfTheSameGenre(Book book);
    public Book getBookByTitle(String title);
    public List<Book> getBooks();
    public Book createBook(Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre);
    public Author createAuthor(String name, String surname, String dob);
    public Author createAuthor(String name, String surname);
    public Book updateBookById(Book book);
}
