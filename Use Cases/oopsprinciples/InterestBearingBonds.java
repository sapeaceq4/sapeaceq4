package com.ace.oopsprinciples;
class InterestBearingBonds extends Bond {

	public InterestBearingBonds(double interest) {
		super(interest);
	}

	double calculateInterest() {
		return bondInterest * 20;
	}

	@Override
	public long priceSecurity() {
		return 1000;
	}
	
}