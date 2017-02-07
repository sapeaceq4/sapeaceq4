package com.sapient.ace.corejava.collections;

public class Fruit implements Comparable<Fruit> {
	private String fruitName;

	public Fruit(String fruitName) {
		this.fruitName = fruitName;
	}

	public Fruit() {
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	@Override
	public int compareTo(Fruit fruit) {

		return this.fruitName.compareTo(fruit.getFruitName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruitName == null) ? 0 : fruitName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		if (fruitName == null) {
			if (other.fruitName != null)
				return false;
		} else if (!fruitName.equalsIgnoreCase(other.fruitName))
			return false;
		return true;
	}

}
