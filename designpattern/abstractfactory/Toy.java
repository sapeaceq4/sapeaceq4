package com.sapient.ace.designpattern.abstractfactory;

public abstract class Toy {

	private String name;
	private int price;
	private String engine;
	private int wheels;
	private int razorBlade;

	public abstract void prepare();

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

	public String getEngine() {
		return engine;
	}

	public int getWheels() {
		return wheels;
	}

	public int getRazorBlade() {
		return razorBlade;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public void setRazorBlade(int razorBlade) {
		this.razorBlade = razorBlade;
	}

}
