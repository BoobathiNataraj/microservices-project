package com.microservice.paymentservice.service;
import org.springframework.stereotype.Service;

import com.microservice.paymentservice.entity.Payment;
import com.microservice.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(Payment payment) {
        payment.setStatus("SUCCESS");  // simulate payment success
        return paymentRepository.save(payment);
    }
}
