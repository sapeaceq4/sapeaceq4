package com.collections;

public class HashTable {

	 public static void main(String[] args) {
		
		int threshold = (int)Math.min(16 * 0.75, Integer.MAX_VALUE - 8 + 1);
		System.out.println("thresold "+threshold);
	}
}
