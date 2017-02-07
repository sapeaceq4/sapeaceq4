package com.ace.excercise.oop.employeeBonusCalculator;

public class Employee {
	protected double salary;
	
	public Employee(double sal) {
		salary = sal;
	}
	public double calculateBonus() {
		return 0.1 * salary;
	}
	

}

class Contractual extends Employee {
	public Contractual(double i) {
		super(i);
	}

	@Override
	public double calculateBonus() {
		return 5000;
	}
}


