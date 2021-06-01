package ua.kpi.library.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.ApplicationTestConfiguration;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.library.model.Role;
import ua.kpi.library.model.User;
import ua.kpi.repository.RoleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationTestConfiguration.class)
@Transactional(isolation = Isolation.SERIALIZABLE)
class BookControllerTest {
    @Autowired
    UserController userController;

    @Autowired
    OrderController orderController;

    @Autowired
    BookController bookController;

    @Autowired
    AdminController adminController;

    @MockBean
    private RoleRepository roleRepository;

    Role role;

    @BeforeEach
    void rolesInitialization() {
        role = new Role();
    }

    @Test
    void should_increase_number_of_orders_in_storage_after_addition() {
        when(roleRepository.findById(1)).thenReturn(Optional.of(role));
        User user = new User("User1", 20, null, null);
        userController.createUser(user);

        Book book = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        bookController.createBook(user.getId(), book);

        int sizeOfOrdersBefore = adminController.getAllOrders().size();

        orderController.createOrder(user.getId(), book.getId(), 10);
        int sizeOfOrdersAfter = adminController.getAllOrders().size();

        assertEquals( 1, sizeOfOrdersAfter - sizeOfOrdersBefore);
    }

    @Test
    void should_decrease_number_of_orders_in_storage_after_deletion() {
        when(roleRepository.findById(1)).thenReturn(Optional.of(role));
        User user = new User("User1", 20, null, null);
        userController.createUser(user);

        Book book = Book.builder().title("The miracle2").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        bookController.createBook(user.getId(), book);
        orderController.createOrder(user.getId(), book.getId(), 10);

        int sizeOfOrdersBefore = adminController.getAllOrders().size();

        orderController.deleteOrder(sizeOfOrdersBefore);
        int sizeOfOrdersAfter = adminController.getAllOrders().size();

        assertEquals(1, sizeOfOrdersBefore - sizeOfOrdersAfter);
    }
}