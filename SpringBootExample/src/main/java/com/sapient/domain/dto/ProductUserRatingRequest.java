package com.sapient.domain.dto;

public final class ProductUserRatingRequest 
{
	private int id;
	private int productId;
	private int userId;
	private double rating;
	
	public ProductUserRatingRequest() {
		
	}

	public ProductUserRatingRequest(int id, int productId, int userId, double rating) {
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}
	
	public int getProductId() {
		return productId;
	}

	public int getUserId() {
		return userId;
	}

	public double getRating() {
		return rating;
	}

}
