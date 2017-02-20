package com.sapient.ProductCatalogRestAndBoot.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sapient.ProductCatalogRestAndBoot.entity.Product;


@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
