package com.ace.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();

		for (int i = 0; i <= 10; i++) {
			List<Integer> row = new ArrayList<Integer>();

			for (int j = 0; j <= 10; j++) {
				row.add(i * j);
			}
			matrix.add(row);
		}

		for (int i = 0; i < matrix.size(); i++) {
			System.out.println(matrix.get(i));
		}

	}
}