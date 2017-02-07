package com.sapient.ace.corejava.collections;

import com.sapient.ace.corejava.collections.AuthorAnnotation;

@AuthorAnnotation(authorName = "Mohit", emailId = "mohit@gmail.com", employeType = "Permanent")
public class Employee implements Comparable<Employee> {
	private String empName;
	private int empId;
	private String deptName;

	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(String empName, int empId, String deptName) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void printEmployee() {
		System.out.print(" Employe name is " + getEmpName());
		System.out.print(" Employee Id is " + getEmpId());
		System.out.println(" Employee's Dept is " + getDeptName());
		// System.out.println("Employee salary is " + getSalary());

	}

	@Override
	public int compareTo(Employee o) {
		return ((Integer) (this.empId)).compareTo(o.getEmpId());
	}

}
