package com.learn.spring.boot.jpa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.learn.spring.boot.jpa.model.Product;
import com.learn.spring.boot.jpa.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	ProductRepository repository;

	@Autowired
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> save(@RequestBody Product product) {
		repository.save(product);
		return ResponseEntity.created(URI.create("/" + product.getId())).body(product);
	}

	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable String productId) {
		return ResponseEntity.ok(repository.findOne(productId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product product) {
		repository.save(product);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String productId) {
		repository.delete(productId);
		return ResponseEntity.ok(productId);
	}
}
