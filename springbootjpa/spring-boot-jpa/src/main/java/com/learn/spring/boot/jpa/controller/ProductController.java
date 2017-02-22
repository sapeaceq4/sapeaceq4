package com.learn.spring.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.boot.jpa.model.Product;
import com.learn.spring.boot.jpa.service.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
ProductRepository repository;
	
	@Autowired
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/createProduct")
	public Product saveProduct() {
		Product product = new Product();

		product.setProductId("1212");
		product.setName("Equity");
		product.setColor("color 2");
		product.setAverageRating(1.2f);

		repository.save(product);

		System.out.println("\n\n\n product has been saved........");
		return product;
	}
	
	@GetMapping("/getProductById")
	 public Product read(@RequestParam String productId) {
		Product product = repository.findByProductId(productId);
	     return product;
	 }
	 
	
	 @PutMapping("/updateProductName")
	 public Product update(@RequestParam String productId, @RequestParam String productName) {
		 Product product = repository.findByProductId(productId);
		 product.setName(productName);
		 product = repository.save(product);
	     return product;
	 }
	 
	
	 @DeleteMapping("/deleteProductById")
	 public String delete(@RequestParam int productId) {
		 repository.delete(productId);
	     return "booking # "+productId+" deleted successfully";
	 }
}
