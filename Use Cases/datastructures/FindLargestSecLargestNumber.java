package com.ace.datastructures;

import java.util.Arrays;

public class FindLargestSecLargestNumber {

	public static void main(String[] args) {
		int[] unsortedArray = {18, 29, -31, -110, 110, 48, -58, 22, -30, 71};

		largestSecLargestNumbers(unsortedArray);
	}

	private static void largestSecLargestNumbers(int[] unsortedArray) {
		int lar = Integer.MIN_VALUE;
		int secLar = Integer.MIN_VALUE;

		for (int i = 0; i < unsortedArray.length; i++) {
			if (unsortedArray[i] > lar) {
				secLar = lar;
				lar = unsortedArray[i];
			} else if (unsortedArray[i] > secLar && unsortedArray[i] != lar)
				secLar = unsortedArray[i];
		}

		System.out.println("Largest Value is : " + lar + "\nSecond Largest Value id : " + secLar);
	}

}