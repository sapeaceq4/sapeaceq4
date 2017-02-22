package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.domain.Product;
import com.sapient.domain.dto.ProductRequest;
import com.sapient.service.IRequestsHandler;
import com.sapient.util.DTOToPOJOConverter;
import com.sapient.util.ProductRatingCalculator;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IRequestsHandler<Product, Integer> requestsHandler;
	
	@Autowired
	ProductRatingCalculator ProductRatingCalculator;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductRequest> create(@RequestBody ProductRequest productRequest) {
		Product product = DTOToPOJOConverter.getProductFromProductRequest(productRequest);
		product = requestsHandler.create(product);
		productRequest = DTOToPOJOConverter.getProductRequestFromProduct(product);
		return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.CREATED);
	}

	@GetMapping(value="/{productId}")
	public ResponseEntity<Product> getByProductId(@PathVariable("productId") int productId) {
		Product product = requestsHandler.getOne(productId);
		
		// Calculate and set Rating of product
		ProductRatingCalculator.calculateRatingForProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Product>> getAllProducts() {
		Iterable<Product> products = requestsHandler.getAll();
		
		// Calculate and set Rating of products
		ProductRatingCalculator.calculateRatingForProducts(products);
		return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductRequest> update(@RequestBody ProductRequest productRequest) {
		Product product = DTOToPOJOConverter.getProductFromProductRequest(productRequest);
		product = requestsHandler.update(product);
		productRequest = DTOToPOJOConverter.getProductRequestFromProduct(product);
		return new ResponseEntity<ProductRequest>(productRequest, HttpStatus.OK);
	}

	@DeleteMapping(value="/{productId}")
	public ResponseEntity<String> delete(@PathVariable("productId") int productId) {
		requestsHandler.delete(productId);
		String response = "Product #"+productId+" deleted successfully";
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}