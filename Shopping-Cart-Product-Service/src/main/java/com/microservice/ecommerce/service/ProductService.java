package com.microservice.ecommerce.service;

import java.util.List;

import com.microservice.ecommerce.model.ProductRequest;
import com.microservice.ecommerce.model.ProductResponse;

public interface ProductService {

	public ProductResponse addProduct(ProductRequest productRequest);

	public List<ProductResponse> getAllProducts();

	public ProductResponse getProduct(Long id);

	public void reduceQuantity(Long id, Long quantity);

}
