package com.java8;

public interface Interface2 {

	default void log1() {
		System.out.println("interface2 log");
	}

	default void log1(String str) {
		System.out.println("interface2 str log "+str);
	}
	
	default String test1(){
		return "default string interface2";
	}
}
