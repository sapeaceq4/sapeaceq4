package com.ace.oopsprinciples;

class Contractors extends Employee {
	
	public Contractors(double salary) {
		super(salary);
	}
	
	@Override
	public double calculateBonus() {
		return 5000;
	}
}