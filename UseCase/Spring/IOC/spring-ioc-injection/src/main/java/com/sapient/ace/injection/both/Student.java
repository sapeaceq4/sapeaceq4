package com.sapient.ace.injection.both;

public class Student {
	private Integer age;
	private String name;
	private Address address;

	public Student(Integer age, String name, Address address) {
		this.age = age;
		this.name = name;
		this.address = address;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(Address address) {
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
