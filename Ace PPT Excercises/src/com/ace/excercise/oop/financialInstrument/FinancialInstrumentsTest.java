package com.ace.excercise.oop.financialInstrument;

public class FinancialInstrumentsTest {
	FinancialInstrument[] portFoilo = new FinancialInstrument[4];
	
	public FinancialInstrumentsTest(){
		portFoilo[0] = new ZeroCouponBonds(200);
		portFoilo[1] = new InterestBreaingBonds(300);
		portFoilo[2] = new VanillaStock();
		portFoilo[3] = new PreferredStock();
	}
	
	
	double calculatePortFolioSecurity() {
		
		double totalPrice = 0;
		for(FinancialInstrument bond: portFoilo){ 
			totalPrice += bond.evaluateSecurity();
		   }
		return totalPrice; 
	}
	
	double calculateBondInterest() {
		
		double interest = 0;
		for(FinancialInstrument bond :portFoilo){  
			if (bond instanceof Bond) {
				interest += ((Bond) bond).calculateInterest();
			}
		   }
		return interest; 
	}
	
	public static void main(String[] args) {

		FinancialInstrumentsTest portFolio = new FinancialInstrumentsTest();
		System.out.println(portFolio.calculatePortFolioSecurity());
		System.out.println(portFolio.calculateBondInterest());
	}	 
}
