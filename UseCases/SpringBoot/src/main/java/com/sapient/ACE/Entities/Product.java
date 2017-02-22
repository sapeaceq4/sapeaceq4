package com.sapient.ACE.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private String name;
	private String color;
	private Float averageRating;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id) {
		this.productId=id;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+productId+"name:"+name+"color:"+color+"averageRating:"+averageRating;
	}

}
