package com.microservice.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders") 
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;
    private Long productId;
    private int quantity;
    private double totalAmount;
    private String status;

	/*
	 * public Long getOrderId() { return orderId; }
	 * 
	 * public void setOrderId(Long orderId) { this.orderId = orderId; }
	 * 
	 * public Long getUserId() { return userId; }
	 * 
	 * public void setUserId(Long userId) { this.userId = userId; }
	 * 
	 * public Long getProductId() { return productId; }
	 * 
	 * public void setProductId(Long productId) { this.productId = productId; }
	 * 
	 * public int getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(int quantity) { this.quantity = quantity; }
	 * 
	 * public double getTotalAmount() { return totalAmount; }
	 * 
	 * public void setTotalAmount(double totalAmount) { this.totalAmount =
	 * totalAmount; }
	 */

	/*
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 */
}
