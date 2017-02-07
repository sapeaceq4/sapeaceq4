package com.sapient.ace.corejava.generics;

import java.util.Arrays;

public class MinMaxBoundTest {

	public static void main(String[] args) {

		Integer[] array = { 12, 31, 53, 47, 16, 53 };
		MinMaxBoundTest test = new MinMaxBoundTest();
		MinMax<Integer, Integer> m = test.calculateMinMax(array);
		System.out.println("Minimum element in the array is :" + m.getFirst());
		System.out.println("Maximum element in the array is :" + m.getSecond());
	}

	private <T extends Comparable<T>> MinMax<T, T> calculateMinMax(T[] array) {
		MinMax<T, T> m = new MinMax<T, T>();
		Arrays.sort(array);
		m.setFirst(array[0]);
		m.setSecond(array[array.length - 1]);
		return m;
	}
}