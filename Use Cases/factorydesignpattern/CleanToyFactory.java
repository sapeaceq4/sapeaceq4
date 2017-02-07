package com.ace.factorydesignpattern;

public class CleanToyFactory {

	private SimpleFactory simpleFactory;

	public SimpleFactory getSimpleFactory() {
		return simpleFactory;
	}

	public void setSimpleFactory(SimpleFactory simpleFactory) {
		this.simpleFactory = simpleFactory;
	}

	public Toy produceToy(String toyName) {
		Toy toy = this.simpleFactory.createToy(toyName);
		toy.prepare();
		toy.pack();
		toy.label();

		return toy;
	}
}
