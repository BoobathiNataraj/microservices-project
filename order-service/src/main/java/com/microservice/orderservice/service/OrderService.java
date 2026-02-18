package com.microservice.orderservice.service;




import org.springframework.stereotype.Service;

import com.microservice.orderservice.client.PaymentClient;
import com.microservice.orderservice.client.ProductClient;
import com.microservice.orderservice.client.UserClient;
import com.microservice.orderservice.dto.PaymentDTO;
import com.microservice.orderservice.dto.ProductDTO;
import com.microservice.orderservice.dto.UserDTO;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.exception.InsufficientStockException;
import com.microservice.orderservice.exception.ProductNotFoundException;
import com.microservice.orderservice.exception.UserNotFoundException;
import com.microservice.orderservice.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;

    public OrderService(OrderRepository orderRepository,
                        UserClient userClient,
                        ProductClient productClient,
                        PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
        this.paymentClient = paymentClient;
    }

    public Order createOrder(Order order) {

        
        UserDTO user = userClient.getUserById(order.getUserId());
        if (user == null) {
            throw new UserNotFoundException("User not found with id " + order.getUserId());
        }

        
        ProductDTO product = productClient.getProductById(order.getProductId());
        if (product == null || product.getPrice() == 0) {
            throw new ProductNotFoundException("Product not available with id " + order.getProductId());
        }
        if (order.getQuantity() > product.getStock()) {
            throw new InsufficientStockException(
                    "Only " + product.getStock() + 
                    " items available. You requested " + order.getQuantity());
        }
        product.setStock(product.getStock() - order.getQuantity());

        
        double totalAmount = product.getPrice() * order.getQuantity();
        order.setTotalAmount(totalAmount);
        order.setStatus("CREATED");

     
        Order savedOrder = orderRepository.save(order);

      
        PaymentDTO payment = new PaymentDTO();
        payment.setOrderId(savedOrder.getOrderId());
        payment.setAmount(savedOrder.getTotalAmount());

        PaymentDTO paymentResponse = paymentClient.makePayment(payment);

      
        if ("SUCCESS".equalsIgnoreCase(paymentResponse.getStatus())) {

            productClient.reduceStock(
                    savedOrder.getProductId(),
                    savedOrder.getQuantity()
            );

            savedOrder.setStatus("PAID");

        } else {
            savedOrder.setStatus("PAYMENT_FAILED");
        }
        return orderRepository.save(savedOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
}
