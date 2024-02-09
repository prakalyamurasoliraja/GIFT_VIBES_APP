package com.learn.springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity; // Converted from themeName to quantity with int data type
    private Date orderDate; // Converted from themeDetails to orderDate with Date data type
    private int orderPrice; // Converted from themePrice to orderPrice
    // Removed imageUrl field

    // Constructors
    public OrderEntity() {
    }

    public OrderEntity(int quantity, Date orderDate, int orderPrice) {
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}