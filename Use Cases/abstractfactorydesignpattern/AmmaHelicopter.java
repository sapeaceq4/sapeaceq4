package com.ace.abstractfactorydesignpattern;

public class AmmaHelicopter extends Toy {
	public AmmaHelicopter(ComponentFactory cf) {
		this.setName("AmmaHelicopter");
		this.setPrice(100);
		this.cf = cf;
	}

	private ComponentFactory cf;

	@Override
	public void prepare() {
		this.cf.createEngine();
		this.cf.createRotorBlade();

	}

	public ComponentFactory getCf() {
		return cf;
	}

	public void setCf(ComponentFactory cf) {
		this.cf = cf;
	}
}
