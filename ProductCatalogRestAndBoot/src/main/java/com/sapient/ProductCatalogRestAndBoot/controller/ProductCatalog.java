package com.sapient.ProductCatalogRestAndBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ProductCatalogRestAndBoot.entity.Product;
import com.sapient.ProductCatalogRestAndBoot.repository.ProductRepository;

@RestController
public class ProductCatalog {
	
	@Autowired
	private ProductRepository dao;
	
	@RequestMapping("/")
	public String sayHello()
	{
		return "Hello ";
	}
	
	@RequestMapping("/getProduct")
	public Product getProductById() {
		
		return dao.findOne(new Integer(1));
	}
	
	@RequestMapping("/save")
	public void saveProduct()
	{
		dao.save(new Product(1,"Rohit", 52, "Black"));
	}
}
