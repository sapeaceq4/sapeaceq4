package com.sapient.ace.usecases;

public class UseCase_14_LargestAndSecondLargestElementInUnSortedArray {

	private static void printMaxAndSecondMaxElement(int[] arr) {
		int max =0, secondMax = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] != max && arr[i] > secondMax) {
				secondMax = arr[i];
			} 

		}

		System.out.println("Max:" + max + ", Second Max: " + secondMax);
	}

	public static void main(String[] args) {

		int arr[] = {3,67,34,89,11,69,32,56,4,9};
		printMaxAndSecondMaxElement(arr);
	}

}
