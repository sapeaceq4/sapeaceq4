package com.sapient.ace.designpattern.factory;

public class SimpleFactory {

	public Toy createToy(String toyName) {
		Toy toy = null;
		if (toyName.equalsIgnoreCase("Car")) {
			toy = new Car();
		} else if (toyName.equalsIgnoreCase("Helicopter")) {
			toy = new Helicopter();
		}
		return toy;
	}
}
