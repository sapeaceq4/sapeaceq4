package com.sapient.ACE.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ACE.Entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	
}
