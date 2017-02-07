package com.ace.oopsprinciples;
class ZeroCouponBonds extends Bond {

		double calculateInterest() {
			
			return bondInterest * 10;
		}

		public ZeroCouponBonds(double interest) {
			super(interest);
		}

		@Override
		public long priceSecurity() {
			return 500;
		}
		
	}