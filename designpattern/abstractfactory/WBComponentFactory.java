package com.sapient.ace.designpattern.abstractfactory;

public class WBComponentFactory extends ComponentFactory {

	@Override
	public void createEngine() {
		System.out.println("Created Didi engine");

	}

	@Override
	public void createWheel() {
		System.out.println("Created Didi wheels");

	}

	@Override
	public void createRotorBlade() {
		System.out.println("Created Didi Rotor Blades");

	}

}
