package ua.kpi.library.controller;

import org.springframework.stereotype.Controller;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.library.service.LibraryService;

import java.util.List;

@Controller
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public Book getBookByTitle(String title) {
        return libraryService.getBookByTitle(title);
    }

    public List<Book> getBooksOfAuthor(Author author) { return libraryService.getBooksOfAuthor(author);}

    public List<Book> getBooksOfTheSameGenre(Book book) { return libraryService.getBooksOfTheSameGenre(book);}

    public List<Book> getBooks(){
        return libraryService.getBooks();
    }

    public Book createBook( Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre) { return libraryService.createBook(authorNew, titleNew, yearNew, publisherNew, costNew, genre);}

    public Author createAuthor( String name, String surname, String dob) { return libraryService.createAuthor(name, surname, dob);}

    public Author createAuthor( String name, String surname) { return libraryService.createAuthor(name, surname);}

    public Book updateBookById(Book book) { return libraryService.updateBookById(book); }
}
