package com.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.orderservice.dto.ProductDTO;

@FeignClient(
	    name = "PRODUCT-SERVICE",
	    fallback = ProductClientFallback.class
	)
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);
    @PutMapping("/products/reduce/{id}")
    void reduceStock(@PathVariable("id") Long id,
                     @RequestParam("quantity") int quantity);
}
