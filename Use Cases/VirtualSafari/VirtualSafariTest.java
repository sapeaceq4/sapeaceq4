package com.ace.VirtualSafari;

public class VirtualSafariTest {

	public static void main(String[] args) {
		Animal[] animals = new Animal[6];
		animals[0] = new Lion();
		animals[1] = new Tiger();
		animals[2] = new Dog();
		animals[3] = new Cat();
		animals[4] = new Elephant();
		animals[5] = new Deer();

		for (int i = 0; i < animals.length; i++) {
			animals[i].eat();
			animals[i].roam();
		}
	}
}
