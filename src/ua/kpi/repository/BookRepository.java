package ua.kpi.repository;

import jdk.jshell.spi.ExecutionControl;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {
    List<Book> test = new ArrayList<>(Arrays.asList(new Book(0), new Book(1, new Author("John", "Doe"), "Monitor", 1967, "Publish", 9.99, BookGenreEnum.ADVENTURE)));


    public Book findBookById(long id) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("findBookById");
    }

    public long createBook(Book book) {
        return 0;
    }

    public Book updateBookById(Book book) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("updateBookById");
    }

    public List<Book> getAllBooks() {
        return test;
    }

    public void deleteBook(long id) {
    }
}
