package com.string;

public class StringTest {

	public static void main(String[] args) {

		String s = "hello";

		System.out.println(s.substring(1, 3));

		String str = new String("quick brown fox jumps over the lazy dog");
		System.out.println("Substring starting from index 15:");
		System.out.println(str.substring(16));
	}
}
