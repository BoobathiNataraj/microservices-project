package com.microservice.productservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.productservice.entity.Product;
import com.microservice.productservice.exception.InsufficientStockException;
import com.microservice.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	
    private ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
	public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
	public void reduceStock(Long productId, int quantity) {

        int updatedRows = productRepository.reduceStock(productId, quantity);

        if (updatedRows == 0) {
            throw new InsufficientStockException(
                    "Not enough stock available");
        }

}
}

