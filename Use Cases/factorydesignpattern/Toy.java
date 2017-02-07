package com.ace.factorydesignpattern;

public abstract class Toy {

	private String name;
	private int price;

	public void prepare() {
		System.out.println("Preparing " + this.getName());

	}

	public void pack() {
		System.out.println("packing " + this.getName());
	}

	public void label() {
		System.out.println("labeling " + this.getName());
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
