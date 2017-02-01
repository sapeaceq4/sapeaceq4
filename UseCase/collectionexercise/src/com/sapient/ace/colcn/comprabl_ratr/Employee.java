package com.sapient.ace.colcn.comprabl_ratr;

public class Employee implements Comparable<Employee>{
	private Integer id;
	private String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return getId().compareTo(o.getId());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
