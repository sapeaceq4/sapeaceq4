package com.sapient.ace.elevator;

public interface WithdrawalChain {
	
	void setNextChain(WithdrawalChain nextChain);

	void withdrawal(Currency cur);

}
