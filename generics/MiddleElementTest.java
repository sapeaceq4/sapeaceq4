package com.sapient.ace.corejava.generics;

public class MiddleElementTest {

	public static void main(String[] args) {

		String[] stringArray = { "Mohit", "Rahul", "Parveen", "Vikas", "Manoj" };
		Integer[] intArray = { 3, 5, 2, 9, 7 };
		System.out.println("Middle element of string aray is  " + returnMiddle(stringArray));
		System.out.println("Middle element of Integer aray is " + returnMiddle(intArray));
	}

	public static <T> T returnMiddle(T[] array) {
		return array[array.length / 2];
	}
}
