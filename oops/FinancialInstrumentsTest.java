package com.sapient.ace.corejava.oops;

public class FinancialInstrumentsTest {
	FinancialInstrument[] instruments = new FinancialInstrument[4];

	public FinancialInstrumentsTest() {
		instruments[0] = new ZeroCouponBonds(200);
		instruments[1] = new InterestBearingBonds(300);
		instruments[2] = new VanillaStock();
		instruments[3] = new PreferredStock();
	}

	double calculatePriceSecurity() {

		double totalSecurity = 0;
		for (FinancialInstrument instrument : instruments) {
			totalSecurity += instrument.priceSecurity();
		}
		return totalSecurity;
	}

	double calculateBondInterest() {

		double totalInterest = 0;
		for (FinancialInstrument instrument : instruments) {
			if (instrument instanceof Bond) {
				totalInterest += ((Bond) instrument).calculateInterest();
			}
		}
		return totalInterest;
	}

	public static void main(String[] args) {

		FinancialInstrumentsTest portFolio = new FinancialInstrumentsTest();
		System.out.println(portFolio.calculatePriceSecurity());
		System.out.println(portFolio.calculateBondInterest());
	}
}
