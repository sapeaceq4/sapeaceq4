package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.domain.Product;
import com.sapient.repository.ProductRepository;

@Service
public class ProductRequestsHandler implements IRequestsHandler<Product, Integer> {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product create(Product prod) {
		Product product = productRepository.save(prod);
		return product;
	}

	@Override
	public Product getOne(Integer id) {
		return productRepository.findOne(id);
	}
	
	@Override
	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product update(Product prod) {
		Product product = productRepository.save(prod);
		return product;
	}

	@Override
	public void delete(Integer id) {
		productRepository.delete(id);
		//TODO Need to implement deletion of all ratings if product deleted.
	}

}
