package com.sapient.ace.elevator;

import java.util.Scanner;

public class ATMWithdrawalChain {

	private WithdrawalChain c1;

	public ATMWithdrawalChain() {
		// initialize the chain
		this.c1 = new RsTwoKWithdrawalChain();
		WithdrawalChain c2 = new RsFiveHundredWithdrawalChain();
		WithdrawalChain c3 = new RsOneHundredWithdrawalChain();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {
		ATMWithdrawalChain atmDispenser = new ATMWithdrawalChain();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to Withdrawal");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.withdrawal(new Currency(amount));
		}

	}
}
