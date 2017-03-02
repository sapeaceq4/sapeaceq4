package com.sapient.ace.elevator;

public class RsTwoKWithdrawalChain implements WithdrawalChain {

	private WithdrawalChain chain;

	public void setNextChain(WithdrawalChain nextChain) {
		this.chain = nextChain;
	}

	public void withdrawal(Currency cur) {
		if (cur.getAmount() >= 2000) {
			int num = cur.getAmount() / 2000;
			int remainder = cur.getAmount() % 2000;
			System.out.println("withdrawing " + num + " Rs. 2000 note");
			if (remainder != 0)
				this.chain.withdrawal(new Currency(remainder));
		} else {
			this.chain.withdrawal(cur);
		}
	}

}
