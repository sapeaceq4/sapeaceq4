package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String productId;
	String name;
	int size;
	String color;
	Rating averageRating;
	
	public Product(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product: [productId: "
				+ productId
				+ ", name: "
				+ name
				+ ", size: "
				+ size
				+ ", color: "
				+ color
				+ ", averageRating: "
				+ averageRating+"]";
	}
}
