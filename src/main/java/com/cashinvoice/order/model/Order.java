package com.cashinvoice.order.model;

import java.time.LocalDateTime;

public class Order {

    private String orderId;
    private String customerId;
    private String product;
    private double amount;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(String orderId, String customerId, String product,
                 double amount, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.product = product;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}