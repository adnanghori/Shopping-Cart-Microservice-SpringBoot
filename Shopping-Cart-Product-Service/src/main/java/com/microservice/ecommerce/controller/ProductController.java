package com.microservice.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.model.ProductRequest;
import com.microservice.ecommerce.model.ProductResponse;
import com.microservice.ecommerce.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.addProduct(productRequest));
	}
	@GetMapping("/")
	public ResponseEntity<List<ProductResponse>> getAllProduct(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.getAllProducts());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.getProduct(id));
	}
	@PutMapping("/reduce-quantity/{id}")
	public ResponseEntity<String> reduceQuantity(@PathVariable Long id , @RequestParam Long quantity){
		this.productService.reduceQuantity(id,quantity);
		return new ResponseEntity<String>("Quantity Reduced By :  "+quantity,HttpStatus.OK);
	}
}
