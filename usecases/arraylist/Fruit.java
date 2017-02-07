package com.sapient.usecases.arraylist;

public class Fruit implements Comparable<Fruit> {
	private String name;

	public Fruit() {
	}

	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Fruit obj) {
		return name.compareTo(obj.getName());
	}

	@Override
	public boolean equals(Object obj) {
		Fruit jo = (Fruit) obj;
		return this.name.equals(jo.getName());
	}
}
