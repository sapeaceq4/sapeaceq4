package com.ace.excercise.oop.employeeBonusCalculator;

public class EmployeeBonusCalci {
	public static void main(String[] args) {
		Employee emp = new Employee(200000);
		Contractual cEmp = new Contractual(10000);
		
		System.out.println("BONUS FOR REGULAR EMPLOYEE CREATED" + emp.calculateBonus());
		System.out.println("BONUS FOR CONTRACTUAL EMPLOYEE CREATED" + cEmp.calculateBonus());
		
	
	}
}
