package com.designpattern.CreationalDesignPattern.factorypattern.ex1;

public class FactoryPatternTest {

	public static void main(String[] args) {
		Animal animal = null;
		animal = AnimalFactory.getAnimal("dog");
		System.out.println("Class name "+animal.getClass().getName());
		System.out.println("Object is " + animal.speak());
		System.out.println();
		animal = AnimalFactory.getAnimal("lion");
		System.out.println("Class name "+animal.getClass().getName());
		System.out.println("Object is " + animal.speak());
		System.out.println();
		animal = AnimalFactory.getAnimal("cat");
		System.out.println("Class name "+animal.getClass().getName());
		System.out.println("Object is " + animal.speak());
		
	}
}
