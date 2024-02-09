package com.learn.springsecurity.service;

import com.learn.springsecurity.model.OrderEntity;
import com.learn.springsecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public OrderEntity updateOrder(Long id, OrderEntity order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order with id " + id + " does not exist.");
        }
    }

    public String deleteOrder(Long id) {
        Optional<OrderEntity> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.deleteById(id);
            return "Order with ID " + id + " deleted successfully";
        } else {
            return "Order with ID " + id + " not found";
        }
    }
}