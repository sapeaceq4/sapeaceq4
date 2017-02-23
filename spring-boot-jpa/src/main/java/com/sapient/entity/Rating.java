package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String id;
	double rating;
	User userId;
	
	@Override
	public String toString() {
		return "Rating: [id: "
				+ id
				+ ", rating: "
				+ rating
				+ ", userId: "
				+ userId
				+"]";
	}
}
