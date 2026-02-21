package com.cashinvoice.order.service;

import com.cashinvoice.order.exception.OrderNotFoundException;
import com.cashinvoice.order.model.Order;
import com.cashinvoice.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String createOrder(String customerId, String product, double amount) {

        String orderId = UUID.randomUUID().toString();

        Order order = new Order(
                orderId,
                customerId,
                product,
                amount,
                LocalDateTime.now()
        );

        repository.save(order);
        return orderId;
    }

    public Order getOrderById(String orderId) {
        return repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    public List<Order> getOrdersByCustomer(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}