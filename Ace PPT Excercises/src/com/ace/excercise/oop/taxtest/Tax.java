package com.ace.excercise.oop.taxtest;

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
		return (grossIncome * 0.1)/dependents;		
	}
}
