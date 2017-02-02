package com.gm.ace;


interface SubClass {
	public static int s = 8;
}
public class InterfaceClass implements SubClass{
	public static int s = 5;
	
	public static void main(String[] args) {
		SubClass i = new InterfaceClass();
		System.out.println(i.s);
		System.out.println(i instanceof SubClass);
		Object o1 = new Object();
		
		Object o2;
	}
}


class EInterfaceClass extends InterfaceClass {
	public static int s = 3;
	
	public static void interfaceFunction(){
		System.out.println("interface can have static function");
	}
}