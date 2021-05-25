package ua.kpi.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"ua.kpi.library.controller", "ua.kpi.library.service"})
@Import(HibernateConfCommon.class)
public class Application {

//    @Bean
//    public LibraryController libraryApi() {
//        return new LibraryController(libraryService());
//    }
//
//    @Bean
//    public LibraryService libraryService() {
//        final LibraryServiceImpl departmentService = new LibraryServiceImpl();
//        return departmentService.setBookService(bookService());
//    }
//
//    @Bean
//    public BookService bookService() {
//        return new BookServiceImpl(bookRepository());
//    }
//
//    @Bean
//    protected BookRepository bookRepository() {
//        return new BookRepository();
//    }

}
