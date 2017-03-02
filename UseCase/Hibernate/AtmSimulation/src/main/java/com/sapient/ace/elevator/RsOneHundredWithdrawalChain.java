package com.sapient.ace.elevator;

public class RsOneHundredWithdrawalChain implements WithdrawalChain {

	private WithdrawalChain chain;

	public void setNextChain(WithdrawalChain nextChain) {
		this.chain = nextChain;
	}

	public void withdrawal(Currency cur) {
		if (cur.getAmount() >= 100) {
			int num = cur.getAmount() / 100;
			int remainder = cur.getAmount() % 100;
			System.out.println("withdrawing " + num + " Rs. 100 note");
			if (remainder != 0)
				this.chain.withdrawal(new Currency(remainder));
		} else {
			this.chain.withdrawal(cur);
		}
	}

}
