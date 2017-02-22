package com.sapient.ace.corejava.oops;

public class Tax {
	private double grossIncome;
	private int dependents;
	private String country;

	public Tax(double grossIncome, String country) {
		this(grossIncome, country, 1);
	}

	public Tax(double grossIncome, String country, int dependents) {
		this.grossIncome = grossIncome;
		this.country = country;
		this.dependents = dependents;
	}

	public void calculateTax() {
		double tax = 0.0;
		if (grossIncome <= 250000) {
			tax = 0.0;
		} else if (grossIncome > 250000 && grossIncome <= 500000) {
			tax = grossIncome * 0.1;
		} else if (grossIncome > 500000 && grossIncome <= 1000000) {
			tax = grossIncome * 0.2;
		} else if (grossIncome > 1000000) {
			tax = grossIncome * 0.3;
		}
		if (!country.equalsIgnoreCase("India")) {
			tax = tax + 10000;
		}
		if (dependents > 2) {
			tax = tax - 5000;
		}
		if (tax > 0) {
			System.out.println("Your payable tax is " + tax);
		} else {
			System.out.println("You don't have to pay any tax");
		}
	}

	public double getGrossIncome() {
		return grossIncome;
	}

	public void setGrossIncome(double grossIncome) {
		this.grossIncome = grossIncome;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
