package com.sapient.ace.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sapient.ace.corejava.collections.Fruit;

public class FruitBasketTest {

	public static void main(String[] args) {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		Fruit fruit1 = new Fruit("Orange");
		Fruit fruit2 = new Fruit("Apple");
		Fruit fruit3 = new Fruit("Guvava");
		Fruit fruit4 = new Fruit("Banana");
		Fruit fruit5 = new Fruit("Mangpo");
		// Add the fruits to list
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		fruitList.add(fruit5);
		// Print the list values
		for (Fruit fruit : fruitList) {
			System.out.println(fruit.getFruitName());
		}
		// Sort the list using collections class
		Collections.sort(fruitList);

		// Print the list values after sorting
		System.out.println("After sorting using API method");
		for (Fruit fruit : fruitList) {
			System.out.println(fruit.getFruitName());
		}

		System.out.println("Enter a fruit name you want to search");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Fruit searchFruit = new Fruit(input);
		// Check if fruit given by user exists in the list
		if (fruitList.contains(searchFruit)) {
			System.out.println("Your fruit " + searchFruit.getFruitName() + " is present in list");
		} else {
			System.out.println("Your fruit " + searchFruit.getFruitName() + " doesn't exist in fruit");
		}
		scanner.close();
	}

}
