package com.sap.ace.services;

import com.sap.ace.models.Product;
import com.sap.ace.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
@Component
public class ProductService implements GenericService<Product, Long> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findOne(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public CrudRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Long getID(Product entity) {
        return null;
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}
