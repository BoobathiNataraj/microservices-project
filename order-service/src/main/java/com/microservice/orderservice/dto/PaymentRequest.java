package com.microservice.orderservice.dto;


import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Double amount;
}

