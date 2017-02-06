package com.ace.annotations;

public class Employee {

	String empName;
	String emailId;
	
	@Deprecated
	public void printEmployee() {
		System.out.println("Name of the employee -" + this.empName +" employee ID is - " + this.emailId);
	}
	
	public static void main(String args[]){
		
		Employee e1 = new Employee();
		e1.empName = "Tulika";
		e1.emailId = "tulika@sapient.com";
		e1.printEmployee();
	}
}
