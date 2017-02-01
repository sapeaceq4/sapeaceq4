package useCases.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FruitBasketTest {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		List<Fruit> arrayList= new ArrayList<Fruit>();
		Fruit apple = new Fruit("Apple");
		Fruit mango = new Fruit("mango");
		Fruit banana = new Fruit("banana");
		Fruit pineapple = new Fruit("pineapple");
		Fruit grape = new Fruit("grape");
		arrayList.add(apple);
		arrayList.add(mango);
		arrayList.add(banana);
		arrayList.add(pineapple);
		arrayList.add(grape);

		Collections.sort(arrayList);
		for(Fruit c: arrayList){
			System.out.println(c.fruitName);
		}
		System.out.println(arrayList.contains(new Fruit(sc.next())));
	}

}
