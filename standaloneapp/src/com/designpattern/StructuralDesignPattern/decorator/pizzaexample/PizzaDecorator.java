package com.designpattern.StructuralDesignPattern.decorator.pizzaexample;

public abstract class PizzaDecorator implements Pizza {

	public Pizza pizza;
	
	public PizzaDecorator(Pizza pizza ){
		this.pizza = pizza;
	}
}