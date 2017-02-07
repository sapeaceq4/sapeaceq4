package com.ace.oopsprinciples;

public class FringeTaxTest {
	public static void main(String[] args) {
		Tax tax1 = new FringeTax(100000, "USA", 1, 0);
		Tax tax2 = new FringeTax(400000, "CHINA", 1, 5000);
		
		System.out.println("Tax for person with 100000 income is " + tax1.calculateTax());
		System.out.println("Tax for person with 400000 income is " + tax2.calculateTax());
	}
}
