package com.sapient.ace.injection.both;

public class Address {
	private String address;
	private int pinCode;

	public Address() {
	
	}
	public Address(String address, int pinCode) {
		this.address = address;
		this.pinCode = pinCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public int getPinCode() {
		return pinCode;
	}

}
