package ua.kpi.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ua.kpi.context.Application;
import ua.kpi.library.controller.LibraryController;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.library.service.BookService;
import ua.kpi.library.service.BookServiceImpl;
import ua.kpi.repository.BookRepository;
//import ua.kpi.library.service.LibraryServiceImpl;

@Slf4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        final ConfigurableEnvironment environment = context.getEnvironment();

        BookRepository bookRepository = context.getBean(BookRepository.class);

        Book book = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        bookRepository.save(book);



    }
}
