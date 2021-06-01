package ua.kpi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.library.model.Order;
import ua.kpi.library.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestParam Integer userId, @RequestParam Integer clothingId, @RequestParam Integer amount) {
        orderService.saveOrder(userId, clothingId, amount);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Integer orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getAllOrders(@PathVariable Integer userId) {
        return orderService.getOrdersOfUser(userId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }
}
