package com.sapient.ace.usecases;

public class LargestAndSecondLargestElementInUnSortedArray {
	
	private static void printMaxAndSecondMaxElement(int[] arr) {
		int max =0, secondMax = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}
		}
		
		System.out.println("Max:" + max + ", Second Max: " + secondMax);
	}

	public static void main(String[] args) {
		
		int arr[] = {3,67,34,89,11,65,32,56,4,9};
		printMaxAndSecondMaxElement(arr);
	}

}
