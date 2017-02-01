package com.sapient.ace.colcn.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestHashSet {

	public static void main(String[] args) {

		insertDataInSetAndSort();
		
		insertDataInTreeSet();
	}

	private static void insertDataInTreeSet() {

		SortedSet<Integer> numbers = new TreeSet<>();
		addNumberToSet(numbers);
		System.out.println("Print the data in Pre-Sorted Set");
		displayData(numbers);
	}

	private static void insertDataInSetAndSort() {
		Set<Integer>  numbers = new LinkedHashSet<>();
		addNumberToSet(numbers);
		
		System.out.println("Print the data before sorting");
		displayData(numbers);
		
		ArrayList<Integer> arrayList = new ArrayList<>(numbers);
		Collections.sort(arrayList, new SortIntegerInDecendingOrder());
		numbers = new HashSet<>(arrayList);
		
		System.out.println("Print the data after sorting");
		displayData(numbers);
	}
	
	private static void addNumberToSet(Set<Integer> numbers) {
		int count = 0;
		while( count < Integer.MAX_VALUE){
			double random = Math.random() * 10;
			int d = (int) random;
			numbers.add(d);
			if(numbers.size() == 10){
				break;
			}
		}
	}
	
	private static void displayData(Set<Integer> numbers) {
		for(Integer number : numbers){
			System.out.print(number + " ");
		}
		System.out.println();
	}

}
