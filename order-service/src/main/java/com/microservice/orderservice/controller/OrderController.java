package com.microservice.orderservice.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // ✅ Constructor injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // CREATE ORDER
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // GET ALL ORDERS
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // GET ORDER BY ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
