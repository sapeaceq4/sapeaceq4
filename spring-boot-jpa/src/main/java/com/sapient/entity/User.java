package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String userId;
	String firstName;
	String lastName;
	String city;
	
	@Override
	public String toString() {
		return "User: [userId: "
				+ userId
				+ ", firstName: "
				+ firstName
				+ ", lastName: "
				+ lastName
				+ ", city: "
				+ city
				+ "]";
	}
}
