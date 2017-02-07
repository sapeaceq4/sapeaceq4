package com.ace.oopsprinciples;

public class TaxTest {
	
	public static void main(String[] args) {
		Tax tax1 = new Tax(100000, "USA");
		Tax tax2 = new Tax(400000, "CHINA");
		
		System.out.println("Tax for person with 100000 income is " + tax1.calculateTax());
		System.out.println("Tax for person with 400000 income is " + tax2.calculateTax());
	}

}