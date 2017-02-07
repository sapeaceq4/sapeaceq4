package com.ace.abstractfactorydesignpattern;

public class WBToyFactory extends ToyFactory {

	@Override
	public Toy createToy(String toyName) {
		Toy toy = null;
		ComponentFactory cf = new WBComponentFactory();
		if (toyName.equalsIgnoreCase("Car")) {
			toy = new DidiCar(cf);
		} else if (toyName.equalsIgnoreCase("Helicopter")) {
			toy = new DidiHelicopter(cf);
		}

		return toy;

	}

}
