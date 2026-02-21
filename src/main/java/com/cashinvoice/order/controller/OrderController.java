package com.cashinvoice.order.controller;

import com.cashinvoice.order.model.Order;
import com.cashinvoice.order.service.OrderService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(
            @RequestParam @NotBlank String customerId,
            @RequestParam @NotBlank String product,
            @RequestParam @Positive double amount) {

        String orderId = service.createOrder(customerId, product, amount);

        Map<String, String> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("status", "CREATED");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        return service.getOrderById(orderId);
    }

    @GetMapping
    public List<Order> getOrdersByCustomer(@RequestParam String customerId) {
        return service.getOrdersByCustomer(customerId);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
}