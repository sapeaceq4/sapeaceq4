package com.sapient.ace.elevator;

public class RsFiveHundredWithdrawalChain implements WithdrawalChain {

	private WithdrawalChain chain;

	public void setNextChain(WithdrawalChain nextChain) {
		this.chain = nextChain;
	}

	public void withdrawal(Currency cur) {
		if (cur.getAmount() >= 500) {
			int num = cur.getAmount() / 500;
			int remainder = cur.getAmount() % 500;
			System.out.println("withdrawing " + num + " Rs. 500 note");
			if (remainder != 0)
				this.chain.withdrawal(new Currency(remainder));
		} else {
			this.chain.withdrawal(cur);
		}
	}

}
