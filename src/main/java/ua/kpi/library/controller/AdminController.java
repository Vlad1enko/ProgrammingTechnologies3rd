package ua.kpi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.library.model.Order;
import ua.kpi.library.model.Status;
import ua.kpi.library.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @PutMapping
    public void changeOrderStatus(@RequestParam Integer orderId, @RequestParam Status status) {
        orderService.changeOrderStatus(orderId, status);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/all/{userId}")
    public List<Order> getUserOrders(@PathVariable Integer userId) {
        return orderService.getOrdersOfUser(userId);
    }
}
