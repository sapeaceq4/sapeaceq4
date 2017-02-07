package com.ace.oopsprinciples;

import java.util.Random;

class Regular extends Employee {
	
	public Regular(double salary) {
		super(salary);
	}
	
	@Override
	public double calculateBonus() {
		Random r = new Random();
		int incrementPercentage = r.nextInt(15-10) + 10;
		double increment = incrementPercentage/100.0 +1;
		return increment*getSalary();
	}
}