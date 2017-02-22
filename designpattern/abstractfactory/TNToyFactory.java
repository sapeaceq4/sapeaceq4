package com.sapient.ace.designpattern.abstractfactory;

public class TNToyFactory extends ToyFactory {

	@Override
	public Toy createToy(String toyName) {
		Toy toy = null;
		ComponentFactory cf = new TNComponentFactory();
		if (toyName.equalsIgnoreCase("Car")) {
			toy = new AmmaCar(cf);
		} else if (toyName.equalsIgnoreCase("Helicopter")) {
			toy = new AmmaHelicopter(cf);
		}

		return toy;

	}

}
