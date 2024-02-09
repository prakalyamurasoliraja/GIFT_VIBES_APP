package com.learn.springsecurity.controller;

import com.learn.springsecurity.model.OrderEntity;
import com.learn.springsecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final OrderService orderService;

    @Autowired
    public PaymentController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<OrderEntity> getAllPayments() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getPaymentById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/")
    public OrderEntity createPayment(@RequestBody @NonNull OrderEntity payment) {
        return orderService.createOrder(payment);
    }

    @PutMapping("/{id}")
    public OrderEntity updatePayment(@PathVariable long id, @RequestBody OrderEntity updatedPayment) {
        return orderService.updateOrder(id, updatedPayment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable long id) {
        return orderService.deleteOrder(id);
    }
}