package com.learn.springsecurity.controller;

import com.learn.springsecurity.model.OrderEntity;
import com.learn.springsecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/")
    public OrderEntity createOrder(@RequestBody @NonNull OrderEntity order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable long id, @RequestBody OrderEntity updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable long id) {
        return orderService.deleteOrder(id);
    }
}