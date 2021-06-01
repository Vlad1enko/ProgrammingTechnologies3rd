package ua.kpi.library.service;

import ua.kpi.library.model.Order;
import ua.kpi.library.model.Status;

import java.util.List;

public interface OrderService {

    void saveOrder(Integer userId, Integer bookId, Integer amount);

    Order getOrder(Integer id);

    List<Order> getAllOrders();

    List<Order> getOrdersOfUser(Integer userId);

    Order changeOrderStatus(Integer orderId, Status status);

    void deleteOrder(Integer id);

}