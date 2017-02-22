package com.sapient.ace.corejava.oops;

public class Employee {
	private String name;
	private double salary;
	private Integer empId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public Employee(String name, double salary, Integer empId) {
		super();
		this.name = name;
		this.salary = salary;
		this.empId = empId;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public double calculateIncrementedSalary() {
		return 0.0;
	}
}
