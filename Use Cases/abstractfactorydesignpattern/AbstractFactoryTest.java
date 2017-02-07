package com.ace.abstractfactorydesignpattern;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		ToyFactory toyFactory = FactoryProducer.getToyFactory("Chennai");
		Toy toy = toyFactory.produceToy("Helicopter");
		System.out.println("Created toy " + toy.getName());
		System.out.println();

		ToyFactory toyFactory2 = FactoryProducer.getToyFactory("Kolkata");
		Toy toy2 = toyFactory2.produceToy("Car");

		System.out.println("Created toy " + toy2.getName());

	}

}
