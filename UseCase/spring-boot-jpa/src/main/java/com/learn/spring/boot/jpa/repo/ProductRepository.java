package com.learn.spring.boot.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.spring.boot.jpa.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	
}
