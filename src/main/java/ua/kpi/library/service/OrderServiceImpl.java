package ua.kpi.library.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.ObjectNotFoundException;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.Order;
import ua.kpi.library.model.Status;
import ua.kpi.library.model.User;
import ua.kpi.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(Hibernate::initialize);
        return orders;
    }

    @Override
    public List<Order> getOrdersOfUser(Integer userId) {
        List<Order> orders = userService.getUser(userId).getOrders();
        orders.forEach(Hibernate::initialize);
        return orders;
    }

    @Override
    public Order changeOrderStatus(Integer orderId, Status status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ObjectNotFoundException("Order", orderId));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public void saveOrder(Integer userId, Integer bookId, Integer amount) {
        Book book = bookService.getBookById(bookId);
        User user = userService.getUser(userId);
        Order order = new Order(user, book, amount, Status.PENDING);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (Exception ex) {
            throw new ObjectNotFoundException("Order", orderId);
        }
    }

    @Override
    public Order getOrder(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Order", id));
        Hibernate.initialize(order);
        return order;
    }
}
