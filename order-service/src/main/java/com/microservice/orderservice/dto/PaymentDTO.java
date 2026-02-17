package com.microservice.orderservice.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long paymentId;
    private Long orderId;
    private Double amount;
    private String status;
}
