package com.designpattern.StructuralDesignPattern.decorator.pizzaexample;

public class Tomatoes extends PizzaDecorator {

	public Tomatoes(Pizza pizza) {
		super(pizza);
	}
	
	public String description() {
		return "Tomatoes";
	}
	
	public double cost(){
		return this.pizza.cost()+5;
		
	}
}
