package ua.kpi.library.service;

import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookByTitle(String title);
    Book createBook(Book book);
    Book getBookById(Integer id);
    List<Book> getBooksOfAuthor(Author author);
    List<Book> getBooksOfGenre(BookGenreEnum genreEnum);
    List<Book> getBooksOfUser(Integer userId);
    void saveBookOfUser(Integer userId, Book book);
    void deleteBook(Integer bookId);
    Book updateBook(Book book);
    void addBookToLibrary(Integer libraryId, Integer bookId);
}
