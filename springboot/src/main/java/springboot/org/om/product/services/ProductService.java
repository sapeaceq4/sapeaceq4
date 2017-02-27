package springboot.org.om.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import springboot.org.om.product.entity.Product;
import springboot.org.om.product.repositories.ProductRepository;

@Component
public class ProductService implements GenericService<Product, Long>
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public CrudRepository<Product, Long> getRepository() 
	{
		return productRepository;
	}
}
