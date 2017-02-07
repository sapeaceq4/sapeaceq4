package com.sapient.ace.corejava.collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Random rand = new Random();
		Set<Integer> integerSet = new HashSet<Integer>();
		Set<Integer> sortedSet = new TreeSet<Integer>();

		for (int i = 0; i < 15; i++) {
			int value = rand.nextInt(11);
			integerSet.add(value);
			sortedSet.add(value);
		}

		System.out.println("size of unsorted set is " + integerSet.size());
		System.out.println("size of sorted set is " + sortedSet.size());

		System.out.println("Print the unsorted set ");
		for (int i : integerSet) {
			System.out.println(i);

		}

		System.out.println("Print the sorted set ");
		for (int i : sortedSet) {
			System.out.println(i);

		}
	}

}
