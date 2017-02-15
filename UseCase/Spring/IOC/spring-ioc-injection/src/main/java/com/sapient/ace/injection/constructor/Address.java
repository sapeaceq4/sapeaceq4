package com.sapient.ace.injection.constructor;

public class Address {
	private String address;
	private int pinCode;

	public Address(String address, int pinCode) {
		this.address = address;
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public int getPinCode() {
		return pinCode;
	}

}
