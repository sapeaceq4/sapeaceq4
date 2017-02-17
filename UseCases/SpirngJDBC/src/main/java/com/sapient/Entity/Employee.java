package com.sapient.Entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;
	
	
	
	public Employee(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
