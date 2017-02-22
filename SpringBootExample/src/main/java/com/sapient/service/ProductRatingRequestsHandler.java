package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.domain.ProductUserRating;
import com.sapient.repository.ProductUserRatingRepository;

@Service
public class ProductRatingRequestsHandler implements IRequestsHandler<ProductUserRating, Integer>{

	@Autowired
	ProductUserRatingRepository productRatingRepository;

	@Override
	public ProductUserRating create(ProductUserRating productUserRating) {
		ProductUserRating prodUserRating = productRatingRepository.save(productUserRating);
		return prodUserRating;
	}

	@Override
	public ProductUserRating getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ProductUserRating> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductUserRating update(ProductUserRating elem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Need to implement deletion of all ratings if product deleted.
		
	}

}
