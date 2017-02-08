package com.oops;

public class Test {

	public static void main(String[] args) {
		
		P p = new P();
		p.m1();
		
		C c = new C();
		c.m1();
		c.m2();
		
		P pnew = new C();
		pnew.m1();
		
	}
}
