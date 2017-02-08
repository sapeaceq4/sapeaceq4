package com.oops;

public class EncapsulationDemo {

	String name;
	int rno;
	String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void showInfo() {
		System.out.println("Name: " + getName());
		System.out.println("R.No: " + getRno());
		System.out.println("Name: " + getAddress());
	}
}
