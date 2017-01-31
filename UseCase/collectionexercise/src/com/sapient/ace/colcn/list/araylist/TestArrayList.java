package com.sapient.ace.colcn.list.araylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {

		Fruit fruit1 = new Fruit("apple");
		Fruit fruit2 = new Fruit("mango");
		Fruit fruit3 = new Fruit("banana");
		Fruit fruit4 = new Fruit("pine-apple");
		Fruit fruit5 = new Fruit("graps");
		
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(fruit1);
		fruits.add(fruit2);
		fruits.add(fruit3);
		fruits.add(fruit4);
		fruits.add(fruit5);
		
		System.out.println("Before sorting" +fruits);
		
		Collections.sort(fruits);
		
		System.out.println("After sorting" +fruits);
		
		boolean present = fruits.contains(new Fruit("apple"));
		
		System.out.println("The given fruit is present ? " + present);
		
	}

}
