package com.mycompany.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mycompany.datamodel.Product;
import com.mycompany.datamodel.ProductRepository;

@Service
public class ProductService implements GenericService<Product, String> {

	private final ProductRepository productRepository;

	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public String getId(Product entity) {
		return entity.getId();
	}

	@Override
	public CrudRepository<Product, String> getRepository() {
		return this.productRepository;
	}

	@Override
	public Iterable<Product> findByName(String productName) {
		System.out.println("produce " + productName);
		return null;
	}
}
