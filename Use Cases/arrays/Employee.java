package com.ace.arrays;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private int id;

	private String name;
	
	private int age;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		int compareQty = o.getId();
		return this.id - compareQty;
	}

	//Sorts by  name
	public static Comparator<Employee> EmployeeNameComparator
	= new Comparator<Employee>() {

		public int compare(Employee e1, Employee e2) {
			String empName1 = e1.getName().toUpperCase();
			String empName2 = e2.getName().toUpperCase();
			return empName1.compareTo(empName2);
		}
	};

}
