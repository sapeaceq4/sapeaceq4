package com.sapient.domain.dto;

public final class UserRequest 
{
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	
	public UserRequest() {
		
	}

	public UserRequest(int id, String productName, String productColor, String productSize)
	{
		this.id = id;
		this.firstName = productName;
		this.lastName = productColor;
		this.city = productSize;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}
}
