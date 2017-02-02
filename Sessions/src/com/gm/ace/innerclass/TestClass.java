package com.gm.ace.innerclass;

public class TestClass {

	public static void main(String[] args) {
		Otherclass otherclass = new Otherclass();
		otherclass.someMethod();
		
		TestClass testClass =  new TestClass();
		NonStatic name = testClass.new NonStatic("");
	}
	public static class class1 {
		public String name;

		class1(String name) {
			this.name = name;
		}
	}
	
	public class NonStatic {
		public String name;

		NonStatic(String name) {
			this.name = name;
		}
	}

}

class Otherclass {
	public void someMethod() {
		TestClass.class1 c1 = new TestClass.class1("Avnish");
		TestClass.class1 c2 = new TestClass.class1("Other");
		System.out.println(c1.name + " " + c2.name);
		
	}

}
