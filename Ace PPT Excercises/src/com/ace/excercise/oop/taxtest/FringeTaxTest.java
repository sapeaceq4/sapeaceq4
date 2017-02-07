package com.ace.excercise.oop.taxtest;

public class FringeTaxTest {
	public static void main(String[] args) {
		Tax obj = new FringeTax(2000, "India",1, 1);
		Tax obj1 = new FringeTax(2000, "India", 2, 2);
		
		System.out.println("Fringe Tax for person having income as Rs 2000 living in India with 1 dependent"
				+ "with benefit of factor 1" + obj.calculateTax());
		System.out.println("Fringe Tax for person having income as Rs 2000 living in India with 2 dependents"
				+ "with benefit of factor 2" + obj1.calculateTax());
	}
}
