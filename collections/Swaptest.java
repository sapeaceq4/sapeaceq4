package com.sapient.ace.corejava.collections;

public class Swaptest {

	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		Test t = new Test();
		t.a = a;
		t.b = b;
		swap(t);
		a = t.a;
		b = t.b;
		System.out.println(a + " " + b);
	}

	public static void swap(Test t) {
		int c = t.a;
		t.a = t.b;
		t.b = c;
	}
}

class Test {
	int a;
	int b;
}
