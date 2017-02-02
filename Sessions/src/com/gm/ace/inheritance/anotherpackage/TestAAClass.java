package com.gm.ace.inheritance.anotherpackage;

import com.gm.ace.inheritance.AA;

public class TestAAClass {
public static void main(String[] args) {
	AA a = new AA();
	//giving error , f1 is the out side of the package
//	a.f1();
	subAA subAA = new subAA();
	subAA.subf1();
	
}
}

class subAA extends AA{
	public void subf1(){
		System.out.println("subF1");
		f1();
	}
}
