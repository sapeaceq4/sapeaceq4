package com.sapient.ace.designpattern.factory;

public class ToyFactory {

	public Toy produceToy(String toyName) {
		Toy toy = null;
		if ("car" == toyName) {
			toy = new Car();
		} else if ("helicopter" == toyName) {
			toy = new Helicopter();
		}

		toy.prepare();
		toy.pack();
		toy.label();

		return toy;
	}
}
