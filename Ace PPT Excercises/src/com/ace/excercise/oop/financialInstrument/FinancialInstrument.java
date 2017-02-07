package com.ace.excercise.oop.financialInstrument;

public interface  FinancialInstrument {
	
   public long evaluateSecurity();
}

abstract class Bond implements FinancialInstrument {
	protected double bondInterest;
	public Bond(double interest) {
		bondInterest = interest;
	}
	abstract double calculateInterest();
}

interface Stock extends FinancialInstrument {
	
}

class ZeroCouponBonds extends Bond {

	double calculateInterest() {
		
		return bondInterest * 10;
	}

	public long evaluateSecurity() {
		
		return 1000;
	}

	public ZeroCouponBonds(double interest) {
		super(interest);
		// TODO Auto-generated constructor stub
	}
	
}

class InterestBreaingBonds extends Bond {

	public InterestBreaingBonds(double interest) {
		super(interest);
		// TODO Auto-generated constructor stub
	}

	double calculateInterest() {
		return bondInterest * 20;
	}

	public long evaluateSecurity() {
		return 2000;
	}
	
}

class VanillaStock implements Stock {

	public long evaluateSecurity() {
		return 3000;
	}
	
}

class PreferredStock implements Stock {

	public long evaluateSecurity() {
		return 4000;
	}
	
}
