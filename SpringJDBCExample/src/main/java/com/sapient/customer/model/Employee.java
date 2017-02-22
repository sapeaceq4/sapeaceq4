package com.sapient.customer.model;

import java.io.Serializable;

public class Employee implements Serializable
{
	private static final long serialVersionUID = -851414310813768567L;
	
	int empId;
	String name;
	int age;
	
	
	public Employee(int custId, String name, int age) {
		this.empId = custId;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return empId;
	}
	public void setId(int custId) {
		this.empId = custId;
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

	@Override
	public String toString() {
		return "Employee [age=" + age + ", empId=" + empId + ", name=" + name
				+ "]";
	}
	
	
}
