package com.microservice.orderservice.client;
import org.springframework.stereotype.Component;

import com.microservice.orderservice.dto.ProductDTO;
@Component
public class ProductClientFallback implements ProductClient {

	@Override
    public ProductDTO getProductById(Long id) {
		
        ProductDTO product = new ProductDTO();
        product.setProductId(id);
        product.setName("DEFAULT PRODUCT");
        product.setPrice(0);
        return product;
    }
}
