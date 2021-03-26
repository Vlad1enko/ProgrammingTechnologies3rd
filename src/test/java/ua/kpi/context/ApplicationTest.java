package ua.kpi.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kpi.library.controller.LibraryController;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @org.junit.jupiter.api.Test
    void getBookByTitle() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        LibraryController libraryController = context.getBean(LibraryController.class);


        assertInstanceOf(ApplicationContext.class, context);
        assertNotNull(libraryController);

        assertNotNull(libraryController.getBooks());

        assertEquals("Monitor", libraryController.getBookByTitle("Monitor").getTitle());

    }

}