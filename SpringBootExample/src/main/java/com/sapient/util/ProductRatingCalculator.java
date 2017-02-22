package com.sapient.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.domain.Product;
import com.sapient.domain.ProductUserRating;
import com.sapient.repository.ProductUserRatingRepository;

@Service
public class ProductRatingCalculator {

	@Autowired
	private ProductUserRatingRepository productUserRatingRepository;

	public Product calculateRatingForProduct(Product product) {
		Iterable<ProductUserRating> iterable = productUserRatingRepository.findAll();
		double rating = 0.0;
		int count = 0;
		for (ProductUserRating prodUserRating : iterable) {
			if (prodUserRating.getProductId() == product.getId()) {
				rating = rating + prodUserRating.getRating();
				count++;
			}
		}

		product.setAvgrating(rating/count);
		return product;
	}

	public Iterable<Product> calculateRatingForProducts(Iterable<Product> products) {
		Iterable<ProductUserRating> productRatings = productUserRatingRepository.findAll();
		for (Product prod : products) {
			double rating = 0.0;
			int count = 0;
			for (ProductUserRating prodUserRating : productRatings) {
				if (prod.getId() == prodUserRating.getProductId()) {
					rating = rating + prodUserRating.getRating();
					count++;
				}
			}
			prod.setAvgrating(rating/count);
		}

		return products;
	}


}
