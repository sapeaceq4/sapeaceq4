package com.designpattern.BehavioralDesignPattern.strategy;

public class ShoppingCartTest {

	public static void main(String[] args) {
	
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("A1", 99);
		Item item2 = new Item("A2", 59);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
/*		List<Item> ites = cart.items;
		
		System.out.println(ites.size());
*/		
		cart.pay(new PaypalStrategy("ssharma209@sapient.com", "sharma"));
		
		cart.pay(new CreditCardStrategy("Shailendra", "1234567898765432", "456", "03/09/2018"));
		
	}
}
