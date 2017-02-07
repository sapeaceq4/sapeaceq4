package com.sapient.ace.corejava.generics;

import java.util.Arrays;

public class MinMaxTest {

	public static void main(String[] args) {

		Integer[] array = { 12, 31, 53, 47, 16, 53 };
		MinMaxTest test = new MinMaxTest();
		MinMax<Integer, Integer> m = test.calculateMinMax(array);
		System.out.println("Minimum element :" + m.getFirst());
		System.out.println("Maximum element  :" + m.getSecond());
	}

	private MinMax<Integer, Integer> calculateMinMax(Integer[] array) {
		MinMax<Integer, Integer> m = new MinMax<Integer, Integer>();
		Arrays.sort(array);
		m.setFirst(array[0]);
		m.setSecond(array[array.length - 1]);
		return m;

	}
}
