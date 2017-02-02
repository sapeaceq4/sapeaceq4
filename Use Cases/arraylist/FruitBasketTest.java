package com.ace.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FruitBasketTest {
	public static void main(String[] args) {
		List<Fruit> fruitBasket = new ArrayList<Fruit>();

		fruitBasket.add(new Fruit("Apple"));
		fruitBasket.add(new Fruit("Mango"));
		fruitBasket.add(new Fruit("Grapes"));
		fruitBasket.add(new Fruit("Pineapple"));
		fruitBasket.add(new Fruit("Guava"));

		Collections.sort(fruitBasket);

		for (Fruit fruit : fruitBasket) {
			System.out.println(fruit);
		}

		System.out.println("Enter a fruit name");
		Scanner scanner = new Scanner(System.in);
		String fruitName = scanner.nextLine();
		
		System.out.println("is "+fruitName +" Present "
				+ fruitBasket.contains(new Fruit(fruitName)));

		System.out.println("is Pineapple Present "
				+ fruitBasket.contains(new Fruit("Pineapple")));
	}
}
