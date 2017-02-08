package com.designpattern.BehavioralDesignPattern.strategy;

public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String name,String cardnumber,String cvv,String dateOfExpiry) {
		this.cardNumber=cardnumber;
		this.name = name;
		this.cvv=cvv;
		this.dateOfExpiry=dateOfExpiry;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(amount+" paid by credit card...");
	}

}
