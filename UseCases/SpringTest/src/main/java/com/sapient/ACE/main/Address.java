package com.sapient.ACE.main;

public class Address {

	private String firstAddress;
	private String city;
	public String getFirstAddress() {
		return firstAddress;
	}
	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	private static Address bbb() {
		System.out.println("Addddddddd");
		return new Address();
		
	}
	
}
