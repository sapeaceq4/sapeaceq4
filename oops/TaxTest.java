package com.sapient.ace.corejava.oops;

public class TaxTest {

	public static void main(String[] args) {
		Tax tax1 = new Tax(200000, "India", 3);
		Tax tax2 = new Tax(300000, "India", 3);
		Tax tax3 = new Tax(800000, "U.S.");
		Tax tax4 = new Tax(1500000, "India", 5);
		tax1.calculateTax();
		tax2.calculateTax();
		tax3.calculateTax();
		tax4.calculateTax();

	}

}
