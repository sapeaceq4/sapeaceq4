package com.sapient.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.domain.Product;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
 
}