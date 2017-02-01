package com.sapient.ACE.ArrayList;

public class Fruit implements Comparable<Fruit>{

	String fruitName;

	public Fruit(String name) {
		// TODO Auto-generated constructor stub
		this.fruitName=name;
	}
	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	
	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return this.fruitName.compareTo(o.fruitName);
	}
	
	@Override
	public boolean equals(Object obj) {
		Fruit f= (Fruit) obj;
		return(this.fruitName.equals(f.fruitName));
	}
	
	
}
