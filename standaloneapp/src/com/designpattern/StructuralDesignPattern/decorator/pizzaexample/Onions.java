package com.designpattern.StructuralDesignPattern.decorator.pizzaexample;

public class Onions extends PizzaDecorator {

	public Onions(Pizza pizza) {
		super(pizza);
	}

	public String description() {
		return "Onions";
	}

	public double cost() {
		return this.pizza.cost() + 2;
	}
}