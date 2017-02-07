	package com.sapient.usecases.cloneable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FruitBasketTest implements Cloneable {
	
	List<Fruit> fruitBasket;
	
	public void setFruitBasket(List<Fruit> fruitBasket) {
		this.fruitBasket = fruitBasket;
	}

	public List<Fruit> getFruitBasket() {
		return fruitBasket;
	}


	public static void main(String[] args) {
		
		List<Fruit> fruitBasket = new ArrayList<Fruit>();
		fruitBasket.add(new Fruit("Apple"));
		fruitBasket.add(new Fruit("Mango"));
		fruitBasket.add(new Fruit("Grapes"));
		fruitBasket.add(new Fruit("Pineapple"));
		fruitBasket.add(new Fruit("Guava"));

		FruitBasketTest test = new FruitBasketTest();
		test.setFruitBasket(fruitBasket); 
		
		FruitBasketTest cloned= new FruitBasketTest();
		try {
			cloned = (FruitBasketTest) test.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println("Cloned Fruit Basket is - ");
		System.out.println(cloned.getFruitBasket());
	}
}
