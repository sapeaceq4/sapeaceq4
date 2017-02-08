package com.designpattern.StructuralDesignPattern.decorator.pizzaexample;

public class PlainPizza implements Pizza {

	public String description() {

		return "plain pizza";
	}

	@Override
	public double cost() {
		return 100;
	}
}
