package SpringBoot.Service;

import org.springframework.stereotype.Service;

import SpringBoot.Domain.Product;

/**
 * 
 * @author asingh
 */
@Service
public interface ProductService {
	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);

	void deleteProduct(Integer id);

}
