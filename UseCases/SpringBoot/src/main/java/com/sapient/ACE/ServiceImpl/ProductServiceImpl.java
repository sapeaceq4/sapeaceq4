package com.sapient.ACE.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.ACE.Entities.Product;
import com.sapient.ACE.Repositry.ProductRepository;
import com.sapient.ACE.service.ProductService;

@Service("prodService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product prod) {
		productRepository.save(prod);
	}

	@Override
	public Product getProduct(int pid) {
		return productRepository.findOne(pid);
	}

	@Override
	public void deleteProduct(int pid) {
		productRepository.delete(pid);
	}

	@Override
	public void updateProduct(Product prod) {
		productRepository.save(prod);
	}

}
