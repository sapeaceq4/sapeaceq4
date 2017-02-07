package com.ace.oopsprinciples;

public class FringeTax extends Tax {
	private int fringeBenefit;
	
	public FringeTax(double grossIncome, String country, int dependents, int fringeBenefit) {
		super(grossIncome, country, dependents);
		this.fringeBenefit = fringeBenefit;
		
	}
	
	public double calculateTax() {
		double tax = super.calculateTax() ;	
		return tax - fringeBenefit;
	}
}
