package com.microservice.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.productservice.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
	 @Modifying
	    @Transactional
	    @Query("UPDATE Product p SET p.stock = p.stock - :quantity " +
	           "WHERE p.id = :id AND p.stock >= :quantity")
	    int reduceStock(@Param("id") Long id,
	                    @Param("quantity") int quantity);
}
