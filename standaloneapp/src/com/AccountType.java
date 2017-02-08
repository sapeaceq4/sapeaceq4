package com;

enum AccountType {
	SAVING, FIXED, CURRENT,SALARY;
	private AccountType() {
		System.out.println("It is a account type");
	}
}
