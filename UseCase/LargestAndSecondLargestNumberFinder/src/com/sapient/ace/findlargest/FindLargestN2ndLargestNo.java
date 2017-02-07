package com.sapient.ace.findlargest;

public class FindLargestN2ndLargestNo {

	public static void main(String[] args) {
		int[] unsortedArray = {-11, 19, 100, 9, 1, 11, 7, -2, 91, -8, 110};

		printTwoLargestValues(unsortedArray);
	}

	private static void printTwoLargestValues(int[] unsortedArray) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int index = 0; index < unsortedArray.length; index++) {
			if (unsortedArray[index] > max1) {
				max2 = max1;
				max1 = unsortedArray[index];
			} else if (unsortedArray[index] > max2 && unsortedArray[index] != max1)
				max2 = unsortedArray[index];
		}

		System.out.println("Largest Value: " + max1 + "\nSecond Largest Value: " + max2);
	}

}
