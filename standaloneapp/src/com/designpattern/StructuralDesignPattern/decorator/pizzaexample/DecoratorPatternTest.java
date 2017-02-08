package com.designpattern.StructuralDesignPattern.decorator.pizzaexample;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		
		Pizza pizza = new PlainPizza();
		pizza = new Tomatoes(pizza);
		pizza = new Onions(pizza);
		System.out.println("You order Plan pizza");
		System.out.println("Total cost for pzza "+pizza.cost());
	}
}
