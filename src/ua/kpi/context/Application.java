package ua.kpi.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.kpi.library.controller.LibraryController;
import ua.kpi.library.service.BookService;
import ua.kpi.library.service.BookServiceImpl;
import ua.kpi.library.service.LibraryService;
import ua.kpi.library.service.LibraryServiceImpl;
import ua.kpi.repository.BookRepository;

@Configuration
public class Application {

    @Bean
    public LibraryController libraryApi() {
        return new LibraryController(libraryService());
    }

    @Bean
    public LibraryService libraryService() {
        final LibraryServiceImpl departmentService = new LibraryServiceImpl();
        return departmentService.setBookService(bookService());
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl(bookRepository());
    }

    @Bean
    protected BookRepository bookRepository() {
        return new BookRepository();
    }

}
