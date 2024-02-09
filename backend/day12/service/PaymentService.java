package com.learn.springsecurity.service;

import com.learn.springsecurity.model.OrderEntity;
import com.learn.springsecurity.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<OrderEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<OrderEntity> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public OrderEntity createPayment(OrderEntity payment) {
        return paymentRepository.save(payment);
    }

    public OrderEntity updatePayment(Long id, OrderEntity updatedPayment) {
        if (paymentRepository.existsById(id)) {
            updatedPayment.setId(id);
            return paymentRepository.save(updatedPayment);
        } else {
            throw new IllegalArgumentException("Payment with id " + id + " does not exist.");
        }
    }

    public String deletePayment(Long id) {
        Optional<OrderEntity> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isPresent()) {
            paymentRepository.deleteById(id);
            return "Payment with ID " + id + " deleted successfully";
        } else {
            return "Payment with ID " + id + " not found";
        }
    }
}