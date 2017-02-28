package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FruitBasket {
	List<String> fruits = new ArrayList<String>();
	
	public void add(String fruit) {
		
		fruits.add(fruit);
		
	}
	
	public List<String> sort(){
		Collections.sort(fruits);
		return fruits;
	}
	
	public String search(String fruit) {
		String result = "Fruit "
				+ fruit
				+ " is not there in basket.";
		int i;
		if(-1 != (i=fruits.indexOf(fruit)))
			result = "Fruit "
					+ fruit
					+ " is found at index "
					+ i;
		System.out.println(result);
		return result;
	}
	
	@Override
	public String toString() {
		String fs = "";
		for(String f: fruits){
			fs += f+" ";
		}
		return "Fruit Basket: [ "
				+ fs
				+ "]"
				;
	}
}
