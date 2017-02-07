package com.ace.factorydesignpattern;

import com.sapeint.ace.designpattern.factory.SimpleFactory;
import com.sapeint.ace.designpattern.factory.Toy;

import com.sapeint.ace.designpattern.factory.CleanToyFactory;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		CleanToyFactory ctf = new CleanToyFactory();
		ctf.setSimpleFactory(new SimpleFactory());
		Toy toy1 = ctf.produceToy("Helicopter");
		System.out.println("Created toy " + toy1.getName());

		System.out.println();
		Toy toy2 = ctf.produceToy("Car");
		System.out.println("Created toy " + toy2.getName());

	}

}
