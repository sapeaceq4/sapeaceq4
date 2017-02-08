package com.java8;

public class Example1 implements Interface1, Interface2 {

	public static void main(String[] args) {

		Interface1 intr = new Example1();
		intr.log();
		intr.log("test");

		System.out.println("");

		Interface2 intr2 = new Example1();
		intr2.log1();
		intr2.log1("test");

	}
}