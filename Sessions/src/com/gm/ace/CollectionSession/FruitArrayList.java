package com.gm.ace.CollectionSession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FruitArrayList {
	public static void main(String[] args) {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		
		fruitList.add(new Fruit("Apple", 5));
		fruitList.add(new Fruit("Graps", 1));
		fruitList.add(new Fruit("Orange", 3));
		
		System.out.println(fruitList);
		
		fruitList.sort(new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		Fruit fruit = new Fruit("Orange", 5);
		
		System.out.println("Fruit is in the basket " + fruitList.contains(fruit));
		
		
	}

}

class Fruit{
	private String name;
	private int weight;
	public Fruit(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		Fruit fruit = (Fruit)obj;
		if(this.name.equalsIgnoreCase(fruit.getName())){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", weight=" + weight + "]";
	}
	
}
