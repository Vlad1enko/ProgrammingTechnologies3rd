package ua.kpi.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean localEmfBean =
//                new LocalEntityManagerFactoryBean();
//        localEmfBean.setPersistenceUnitName("ua.kpi.jpa");
//        return localEmfBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
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
