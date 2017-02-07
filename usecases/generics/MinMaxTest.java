package com.sapient.usecases.generics;

import java.util.Arrays;

public class MinMaxTest {

	public static void main(String[] args) {
		
		Integer[] array = {2,1,3,4,6,5};
		MinMaxTest obj = new MinMaxTest();
		MinMax<Integer, Integer> m = obj.calculateMinMax(array);
		System.out.println("Minimum element in the array is :" + m.getFirst());
		System.out.println("Maximum element in the array is :" + m.getSecond());
	}
	
	private MinMax<Integer, Integer> calculateMinMax(Integer[] array) {
		MinMax<Integer, Integer> m = new MinMax<Integer, Integer>();
		Arrays.sort(array);
		m.setFirst(array[0]);
		m.setSecond(array[array.length-1]);
		return m;
		
	}
}
