package ua.kpi.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kpi.context.Application;
import ua.kpi.library.controller.LibraryController;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        LibraryController libraryController = context.getBean(LibraryController.class);

        System.out.println(libraryController.getBookByTitle("Monitor"));
        System.out.println(libraryController.getBooksOfAuthor(new Author("John", "Doe")));
        System.out.println(libraryController.getBooksOfTheSameGenre(new Book(2)));
        System.out.println(libraryController.getBooks());
    }
}
