package com.sapient.usecases.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> randomSet = new HashSet<Integer>();
		for(int i=0;i<15;i++)
		{
			randomSet.add(random.nextInt(10));
		}
		System.out.println("Elements are - ");
		for(Integer number : randomSet) {
			System.out.println(number);
		}
		sortInDescOrder(randomSet);
		preSortedSet(randomSet);
		

	}
	
	public static void preSortedSet(Set<Integer> set) {
		Set<Integer> preSortedSet = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		preSortedSet.addAll(set);
		System.out.println("Pre-Sorted elements in descending order - ");
		for(Integer number : preSortedSet) {
			System.out.println(number);
		}
	}
	
	private static void sortInDescOrder(Set<Integer> set) {
		System.out.println("Sorted elements in descending order - ");
		List<Integer> sortedSet = new ArrayList<>(set);
		Collections.sort(sortedSet, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		for(Integer sorted : sortedSet)
			System.out.println(sorted);
	}

}