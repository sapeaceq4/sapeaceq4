package com.sapient.usecases.VirtualSafari;

abstract class Animal {
	private String name;
	private String picture;
	private String food;
	private String hunger;
	private String boundary;
	
	// behavior
	abstract public void speak();
	abstract public void eat();
	public void sleep() {
		System.out.println("Animal sleeps.");
	}
	public void roam() {
		System.out.println("Animal roams around.");
	}
}