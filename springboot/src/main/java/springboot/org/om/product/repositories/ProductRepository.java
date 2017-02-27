package springboot.org.om.product.repositories;

import org.springframework.data.repository.CrudRepository;

import springboot.org.om.product.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long>
{}