package com.ace.oopsprinciples;

public class Employee {
	private String name;
	private int id;
	private int age;
	protected double salary;
	
	public Employee(double salary) {
		this.salary = salary;
	}
	
	public double calculateBonus() {
		return 0.1 * salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
