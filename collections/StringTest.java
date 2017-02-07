package com.sapient.ace.corejava.collections;

public class StringTest {

	public static void main(String[] args) {
		String s2 = new String("hello");
		String s3 = new String("hello");
		String s1 = "hello";
		String s4 = "hello";
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);

	}

}
