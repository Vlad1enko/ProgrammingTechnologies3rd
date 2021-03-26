package ua.kpi.library.controller;

import org.junit.Before;
import org.junit.jupiter.api.function.Executable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kpi.context.Application;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

    LibraryController libraryController = context.getBean(LibraryController.class);

    @org.junit.jupiter.api.Test
    void getBookByTitle() {

        assertEquals("Monitor", libraryController.getBookByTitle("Monitor").getTitle());

    }

    @org.junit.jupiter.api.Test
    void getBooksOfAuthor() {

        assertThrows(BookNotFoundException.class,() -> libraryController.getBooksOfAuthor(new Author("John","Dell")));
        assertEquals(List.of(libraryController.getBookById(1)), libraryController.getBooksOfAuthor(new Author("John","Doe")));
    }

    @org.junit.jupiter.api.Test
    void getBooksOfTheSameGenre() {

        assertEquals(new Book(3).getGenre(), libraryController.getBooksOfTheSameGenre(libraryController.getBookById(0)).get(0).getGenre());
    }

    @org.junit.jupiter.api.Test
    void getBooks() {
        assertEquals(List.of(libraryController.getBookById(0), libraryController.getBookById(1)), libraryController.getBooks());
    }

    @org.junit.jupiter.api.Test
    void createBook() {

        libraryController.createBook(new Author("John", "Maserati"), "Car",1978,"Roadster",15.32, BookGenreEnum.ADVENTURE);

        List<Book> temp = libraryController.getBooks();
        Collections.reverse(temp);

        assertEquals("Car", temp.get(0).getTitle());
    }
}