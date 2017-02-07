package com.ace.abstractfactorydesignpattern;

public abstract class ToyFactory {
	public Toy produceToy(String toyName) {

		Toy toy = createToy(toyName);
		toy.prepare();
		toy.pack();
		toy.label();
		return toy;
	}

	abstract public Toy createToy(String toyName);

}
