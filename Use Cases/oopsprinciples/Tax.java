package com.ace.oopsprinciples;

public class Tax {
	
	private double grossIncome;
	private String country;
	private int dependents;
	
	public Tax(double grossIncome, String country, int dependents) {
		super();
		this.grossIncome = grossIncome;
		this.country = country;
		this.dependents = dependents;
	}
	
	public Tax(double grossIncome, String country) {
		this(grossIncome, country, 1);
	}
	
	
	public double calculateTax() {
		double tax = 0.0;
		if (grossIncome <= 250000) {
			return tax;
		} else if (grossIncome > 250000 && grossIncome <= 500000) {
			tax = grossIncome * 0.1;
		} else if (grossIncome > 500000 && grossIncome > 750000) {
			tax = grossIncome * 0.2;
		} else
			tax = grossIncome * 0.3;

		return tax;
	}
}
