package com.sapient.ace.corejava.collections;

import com.sapient.ace.corejava.collections.Walkman;

public class MethodSignatureTest {

	public void printSomeThing(Walkman wm) {

		System.out.println("something");
	}

	/*
	 * method signature only include method name and no/order of arguments. For
	 * overloading no/type/order of the arguments should differ. public void
	 * printSomeThing() {
	 * 
	 * System.out.println("something"); }
	 */
	public static void main(String[] args) {

	}

}
