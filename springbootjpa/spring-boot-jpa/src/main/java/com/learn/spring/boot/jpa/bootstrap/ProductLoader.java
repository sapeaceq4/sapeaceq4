package com.learn.spring.boot.jpa.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.learn.spring.boot.jpa.model.Product;
import com.learn.spring.boot.jpa.service.ProductRepository;

public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	ProductRepository repository;
	
	@Autowired
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Product product = new Product();
		
		product.setProductId("1212z");
		product.setName("Equity");
		product.setColor("color 1");
		product.setAverageRating(1.1f);
		
		repository.save(product);
		
		System.out.println("\n\n\n product has been saved........");
		
		
	}

}
