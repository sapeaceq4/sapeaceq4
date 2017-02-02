package com.gm.ace;

public class InterfaceExample {
	public static void main(String[] args) {
		Interface itr = new ExtendedClass();
		itr.fun1();
		itr.fun2();
		Interface.fun3();
		
		System.out.println(Interface.var1);
		System.out.println(Interface.var2);
		// cannot do that
//		Interface.var2 = 45;
		
		
	}
}

interface Interface {
	// Prompt to initialize
	public static int var1 = 45;
	// must be initialize
	public int var2 = 32;

	// not permitted
	// private int var3;
	// no setter and getter allowed
	// public int getVar3() {
	// return var3;
	// }
	//
	// public void setVar3(int var3) {
	// this.var3 = var3;
	// }

	void fun1();

	// Not allowed to be have function like this
	// public void fun2() {
	// System.out.println("fun2");
	// }

	default void fun2() {
		System.out.println("fun2");
	}

	public static void fun3() {
		System.out.println("fun3");
	}
}

class ExtendedClass implements Interface {

	@Override
	public void fun1() {
		System.out.println("fun 1 implemented by extended class");

	}
	
	@Override
	public void fun2(){
		System.out.println("Fun 2 method of extended class");
	}

}
