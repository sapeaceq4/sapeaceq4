package com.designpattern.CreationalDesignPattern.factorypattern.ex1;

public class AnimalFactory {

	public static Animal getAnimal(String type) {
		Animal animal = null;
		if ("dog".equals(type)) {
			animal = new Dog();
		} else if ("cat".equals(type)) {
			animal = new Cat();
		} else if ("lion".equals(type)) {
			animal = new Lion();
		}

		return animal;
	}
}
