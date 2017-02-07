package com.ace.oopsprinciples;

abstract class Bond implements FinancialInstrument {
	protected double bondInterest;
	
	public Bond(double interest) {
		bondInterest = interest;
	}
	abstract double calculateInterest();
}
