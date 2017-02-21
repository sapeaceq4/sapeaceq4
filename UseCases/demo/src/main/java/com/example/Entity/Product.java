package com.example.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int product_id;
	private String name;
	private int size;
	private String color;
	private long averageRating;
	
	Product()
	{
		
	}
	
	public Product(int product_id, String name, int size, String color, long averageRating) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.size = size;
		this.color = color;
		this.averageRating = averageRating;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(long averageRating) {
		this.averageRating = averageRating;
	}
	
	
	
	

}
