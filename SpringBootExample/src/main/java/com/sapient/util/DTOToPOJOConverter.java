package com.sapient.util;

import com.sapient.domain.Product;
import com.sapient.domain.ProductUserRating;
import com.sapient.domain.User;
import com.sapient.domain.dto.ProductRequest;
import com.sapient.domain.dto.ProductUserRatingRequest;
import com.sapient.domain.dto.UserRequest;

public class DTOToPOJOConverter {
	
	public static Product getProductFromProductRequest(ProductRequest productRequest) {
		return new Product(productRequest.getId(), productRequest.getProductName(), productRequest.getProductSize(), productRequest.getProductColor());
	}
	
	public static ProductRequest getProductRequestFromProduct(Product product) {
		return new ProductRequest(product.getId(), product.getName(),  product.getColor(), product.getSize());
	}
	
	public static User getUserFromUserRequest(UserRequest userRequest) {
		return new User(userRequest.getId(), userRequest.getFirstName(), userRequest.getLastName(), userRequest.getCity());
	}
	
	public static UserRequest getUserRequestFromUser(User user) {
		return new UserRequest(user.getId(), user.getFirstName(), user.getLastName(), user.getCity());
	}
	
	public static ProductUserRating getProductRatingFromProductRatingRequest(ProductUserRatingRequest productUserRatingRequest) {
		return new ProductUserRating(productUserRatingRequest.getId(), productUserRatingRequest.getUserId(), productUserRatingRequest.getProductId(), productUserRatingRequest.getRating());
	}
	
	public static ProductUserRatingRequest getProductRatingRequestFromProductRating(ProductUserRating productUserRating) {
		return new ProductUserRatingRequest(productUserRating.getId(), productUserRating.getProductId(), productUserRating.getUserId(), productUserRating.getRating());
	}

}
