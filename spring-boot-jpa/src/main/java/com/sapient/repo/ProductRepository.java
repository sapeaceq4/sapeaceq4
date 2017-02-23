package com.sapient.repo;


import org.springframework.data.repository.CrudRepository;

import com.sapient.entity.Product;


public interface ProductRepository extends CrudRepository<Product,Integer> {
	@Override
	<S extends Product> S save(S entity) ;
	
	@Override
	Product findOne(Integer id);
	
	@Override
	void delete(Integer id);
	
}
