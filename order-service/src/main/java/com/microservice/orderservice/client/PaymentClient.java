package com.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.microservice.orderservice.dto.PaymentResponse;
import com.microservice.orderservice.dto.PaymentDTO;
import com.microservice.orderservice.dto.PaymentRequest;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

	@PostMapping("/payments")
    PaymentDTO makePayment(@RequestBody PaymentDTO payment);
}

