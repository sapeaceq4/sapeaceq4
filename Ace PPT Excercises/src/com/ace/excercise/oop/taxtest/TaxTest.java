package com.ace.excercise.oop.taxtest;

public class TaxTest {
	
	public static void main(String[] args) {
		Tax obj = new Tax(2000, "India");
		Tax obj1 = new Tax(2000, "India", 2);
		
		System.out.println("Tax for person having income as Rs 2000 living in India with 1 dependent" +
		obj.calculateTax());
		System.out.println("Tax for person having income as Rs 2000 living in India with 2 dependent" +
		obj1.calculateTax());
	}

}
