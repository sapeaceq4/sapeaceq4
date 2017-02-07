package com.ace.generics;

public class MiddleElementTest {

	public static void main(String[] args) {
		Integer[] array = {2,1,3,4,5};
		MiddleElementTest obj = new MiddleElementTest();
		Integer m = obj.middleElement(array);
		System.out.println("Middle element of the Integer array is :" + m);
		
		String[] array1 = {"Tulika", "Sachin", "Srishti"};
		String m1 = obj.middleElement(array1);
		System.out.println("Middle element of the String array is :" + m1);
	}
	
	private <T> T middleElement(T[] array) {
		return array[array.length/2];	
	}
}
