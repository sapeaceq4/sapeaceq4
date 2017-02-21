package com.learn.spring.boot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {

	@Id
	@GeneratedValue
	private Long id;

	private double rating;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "user_id")
	private String userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", productId=" + productId + ", userId=" + userId + "]";
	}

}
