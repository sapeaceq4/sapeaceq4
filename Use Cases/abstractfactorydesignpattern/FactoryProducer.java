package com.ace.abstractfactorydesignpattern;

public class FactoryProducer {

	public static ToyFactory getToyFactory(String location) {
		if (location.equalsIgnoreCase("Chennai")) {
			return new TNToyFactory();

		}
		if (location.equalsIgnoreCase("Kolkata")) {
			return new WBToyFactory();

		}

		return null;

	}
}
