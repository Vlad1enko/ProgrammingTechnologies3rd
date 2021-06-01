package ua.kpi.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.library.service.BookService;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @org.junit.jupiter.api.Test
    void getBookByTitle() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        BookService bookService = context.getBean(BookService.class);

        Book book = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        bookService.createBook(book);

        assertInstanceOf(ApplicationContext.class, context);
        assertNotNull(bookService);

        assertNotNull(bookService.getBooks());

        assertEquals("The miracle", bookService.getBookById(1).getTitle());

    }

}