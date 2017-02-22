package com.sapient.ace.designpattern.abstractfactory;

public class AmmaCar extends Toy {

	public AmmaCar(ComponentFactory cf) {
		this.setName("AmmaCar");
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
