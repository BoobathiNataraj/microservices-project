package com.microservice.paymentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Optional<Payment> findByOrderId(Long orderId);
}
