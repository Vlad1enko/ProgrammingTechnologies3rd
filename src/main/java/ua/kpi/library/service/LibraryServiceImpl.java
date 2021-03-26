package ua.kpi.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BookService bookService;

    @Override
    public List<Book> getBooksOfAuthor(Author author) {
        return of(author)
                .map(a -> bookService.getBooks().stream()
                        .filter(book -> book.getAuthor().equals(a))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                            if ( result.isEmpty()) {
                                throw new BookNotFoundException(author);
                            }
                            return result;
                        }))
                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }

    @Override
    public Book getBookById(long id) {
        return bookService.getBookById(id);
    }

    @Override
    public List<Book> getBooksOfTheSameGenre(Book book) {
        return of(book)
                .map(b -> bookService.getBooks().stream()
                        .filter(bookFilter -> bookFilter.getGenre().equals(b.getGenre()))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                            Collections.shuffle(collected);
                            return collected.stream();
                        }))
                        .limit(5)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                            if ( result.isEmpty()) {
                                throw new BookNotFoundException(book.getGenre());
                            }
                            return result;
                        }))
                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookService.getBookByTitle(title);
    }

    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    public Book createBook( Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre) {
        return bookService.createBook(authorNew, titleNew, yearNew, publisherNew, costNew, genre);
    }

    public Author createAuthor(String name, String surname, String dob) {
        return new Author(name, surname, dob);
    }

    public Author createAuthor(String name, String surname) {
        return new Author(name, surname);
    }

    public Book updateBookById(Book book) {
        return bookService.updateBookById(book);
    }

    public LibraryService setBookService(BookService bookService) {
        this.bookService = bookService;
        return this;
    }
}
