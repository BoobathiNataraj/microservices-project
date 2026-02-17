package com.microservice.paymentservice.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.paymentservice.entity.Payment;
import com.microservice.paymentservice.service.PaymentService;
import com.microservice.paymentservice.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private PaymentRepository paymentRepository;
    
    public PaymentController(PaymentService paymentService,PaymentRepository paymentRepository) {
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }
    
    
   
    

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentService.makePayment(payment);
    }
	/*
	 * @PostMapping("/payments") public Payment makePayment(@RequestBody Payment
	 * payment) { payment.setStatus("SUCCESS"); return
	 * paymentRepository.save(payment); }
	 */
    
    // 🔹 Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // 🔹 Get payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }

    // 🔹 Get payment by Order ID (important for microservices)
    @GetMapping("/order/{orderId}")
    public Payment getPaymentByOrderId(@PathVariable Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found for orderId " + orderId));
    }

}
