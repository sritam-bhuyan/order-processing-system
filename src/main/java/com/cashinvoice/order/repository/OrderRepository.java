package com.cashinvoice.order.repository;

import com.cashinvoice.order.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderStore = new HashMap<>();

    public void save(Order order) {
        orderStore.put(order.getOrderId(), order);
    }

    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(orderStore.get(orderId));
    }

    public List<Order> findByCustomerId(String customerId) {
        return orderStore.values()
                .stream()
                .filter(o -> o.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderStore.values());
    }
}