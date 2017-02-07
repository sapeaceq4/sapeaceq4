package com.ace.usecase;

import java.util.Arrays;
import java.util.List;
/**
 * Implement Merge Sort
 * @author asi233
 *
 */
public class MergeSort {
	
	public static List<Integer> sort(List<Integer> list) {
		Integer[] numbers = new Integer[list.size()];
		list.toArray(numbers);
		mergeSort(numbers, 0, list.size() - 1);
		return Arrays.asList(numbers);
	}

	private static void mergeSort(Integer[] numbers, int low, int high) {
		if (low >= high) {
			return;
		}
		int midle = low + (high - low)/2;

		mergeSort(numbers, low, midle);
		mergeSort(numbers, midle + 1, high);

		merge(numbers, low, midle, high);
	}

	private static void merge(Integer[] numbers, int low, int midle, int high) {
		int j = low, k = midle + 1;
		int index = 0;
		Integer arr[] = new Integer[high - low +1];
		while (j <= midle && k <= high) {
			if (numbers[j] > numbers[k]) {
				arr[index++] = numbers[k++];
			} else {
				arr[index++] = numbers[j++];
			}
		}

		while (j <= midle) {
			arr[index++] = numbers[j++];
		}

		while (k <= high) {
			arr[index++] = numbers[k++];
		}
		
		for(int i = 0; i < arr.length;i++) {
			numbers[low++] = arr[i];
		}
	}

}
