package com.gm.ace.inheritance;

public class ProtectedExample {
	public static void main(String[] args) {
		C c = new C();
		c.f3();
	}
}

class A extends ProtectedExample{
	protected void f1(){
		System.out.println("A");
	}
}

class B extends A {
	public void f2(){
		System.out.println("B");
	}
}

class C extends B{
	public void f3(){
		System.out.println("C");
		f1();
	}
}
