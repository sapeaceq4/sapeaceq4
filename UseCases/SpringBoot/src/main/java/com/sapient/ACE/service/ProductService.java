package com.sapient.ACE.service;

import com.sapient.ACE.Entities.Product;

public interface ProductService {

	public void saveProduct(Product prod);
	public Product getProduct(int pid);
	public void deleteProduct(int pid);
	public void updateProduct(Product prod);
	
}
