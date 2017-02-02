package com.gm.ace.polymorphism;

public class OverrideMethod {
	public OverrideMethod() {
		System.out.println("constractor called");
	}

	void OverrideMethod() {
		System.out.println("Method called");
	}

	public static void main(String[] args) {
		OverrideMethod method = new OverrideMethod();
		method.OverrideMethod();
	}
}

class SuperClass {
	void firstMethodOfSuperClass() {
		System.out.println("From Super Class");
	}

	double secondMethodOfSuperClass() {
		return 0.0;
	}

	Object thirdMethodOfSuperClass() {
		return new Object();
	}

	protected void fourthMethohdOfSuperClass() {
		System.out.println("Fourth method");
	}
}

class SubClass extends SuperClass {
//	int firstMethodOfSuperClass() {
//		// Compile time error, return type must be void not int
//	}
//
//	void secondMethodOfSuperClass() {
//		// Complie time error, return type must be double not void
//	}
//
//	String thirdMethodOfSuperClass() {
//		// No Compile time error,
//		// return type is compatible with super class method, because
//		// String is sub class of Object class
//		return new String();
//	}
//
//	private void fourthMethohdOfSuperClass() {
//
//	}
}
