package com.microservice.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.orderservice.dto.ProductDTO;

@FeignClient(
	    name = "PRODUCT-SERVICE",
	    fallback = ProductClientFallback.class
	)
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);
}
