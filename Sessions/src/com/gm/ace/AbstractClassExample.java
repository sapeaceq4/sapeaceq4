package com.gm.ace;

public class AbstractClassExample {
	public static void main(String[] args) {
		Abs absObject = new SubAbs();
		
		absObject.fun1();
		absObject.fun2();
		Abs.fun3();
		System.out.println(absObject.getVar3());
		System.out.println(Abs.var1);
		System.out.println(absObject.var2);
		
	}
}

abstract class Abs {

	public static int var1;

	public int var2;

	private int var3;

	public int getVar3() {
		return var3;
	}

	public void setVar3(int var3) {
		this.var3 = var3;
	}

	abstract void fun1();

	public void fun2() {
		System.out.println("fun2");
	}

	public static void fun3() {
		System.out.println("fun3");
	}
}

class SubAbs extends Abs {

	@Override
	void fun1() {
		System.out.println("fun1 is defined in sub class");
	}

}
