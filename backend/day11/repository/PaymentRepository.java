package com.learn.springsecurity.repository;

import com.learn.springsecurity.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<OrderEntity, Long> {
}