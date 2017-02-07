package com.ace.abstractfactorydesignpattern;

public class DidiCar extends Toy {

	public DidiCar(ComponentFactory cf) {
		this.setName("DidiCar");
		this.setPrice(100);
		this.cf = cf;
	}

	private ComponentFactory cf;

	@Override
	public void prepare() {
		this.cf.createEngine();
		this.cf.createWheel();

	}

	public ComponentFactory getCf() {
		return cf;
	}

	public void setCf(ComponentFactory cf) {
		this.cf = cf;
	}

}
