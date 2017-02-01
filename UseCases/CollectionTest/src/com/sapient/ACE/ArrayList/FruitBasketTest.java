package com.sapient.ACE.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FruitBasketTest {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		List<Fruit> arrayList= new ArrayList<Fruit>();
		for(int index=0;index<5;index++){
			arrayList.add(new Fruit(sc.next()));
		}
		
		Collections.sort(arrayList);
		for(Fruit c: arrayList){
			System.out.println(c.getFruitName());
		}
		System.out.println(arrayList.contains(new Fruit(sc.next())));
	}

}
