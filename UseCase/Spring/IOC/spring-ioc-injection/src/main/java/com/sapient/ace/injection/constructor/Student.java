package com.sapient.ace.injection.constructor;

public class Student {
	private Integer age;
	private String name;
	private Address address;

	public Student(Integer age, String name, Address address) {
		this.age = age;
		this.name = name;
		this.address = address;
	}


	public Integer getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}

}
