package com.ace.abstractfactorydesignpattern;

public class TNComponentFactory extends ComponentFactory {

	@Override
	public void createEngine() {
		System.out.println("Created Amma engine");

	}

	@Override
	public void createWheel() {
		System.out.println("Created Amma wheels");

	}

	@Override
	public void createRotorBlade() {
		System.out.println("Created Amma Rotor Blades");

	}

}
