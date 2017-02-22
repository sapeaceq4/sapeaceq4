package com.learn.spring.boot.jpa.service;

import org.springframework.data.repository.CrudRepository;

import com.learn.spring.boot.jpa.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product findByProductId(String productId);
}
