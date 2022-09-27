package com.microservice.ecommerce.service.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.microservice.ecommerce.entity.Product;
import com.microservice.ecommerce.exception.ProductServiceException;
import com.microservice.ecommerce.model.ProductRequest;
import com.microservice.ecommerce.model.ProductResponse;
import com.microservice.ecommerce.repository.ProductRepository;
import com.microservice.ecommerce.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor 
@Log4j2
public class ProductServiceAdapter implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {
		
		log.info("Adding Product");
	
		Product product = this.modelMapper.map(productRequest, Product.class);
		return this.modelMapper.map(this.productRepository.save(product), ProductResponse.class);
		
		
	}
	@Override
	public List<ProductResponse> getAllProducts() {
		log.info("Getting All Products");
		try {
			return this.productRepository.findAll().stream().map(product -> this.modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
		} catch (ProductServiceException e) {

			throw new ProductServiceException("Product", "Not Found");
		}
		 
		
	}
	@Override
	public ProductResponse getProduct(Long id) {
		log.info("Getting Single Product");
		Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product With ID : "+id," Not Found"));
		return this.modelMapper.map(product, ProductResponse.class);
	}
	@Override
	public void reduceQuantity(Long id, Long quantity) {
		
		 log.info("Reducing Quantity {} ", id,quantity  );
		 Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product With ID : "+id, "Not Found"));
		
		 if(product.getProductQuantity()<quantity) {
			 throw new ProductServiceException("Low Stock", "Insufficient Quantity");
		 }
		 product.setProductQuantity(product.getProductQuantity()-quantity);
		 this.productRepository.save(product); 
		 log.info("Quantity Reduced Successfully ");
		
	}
	
}
 