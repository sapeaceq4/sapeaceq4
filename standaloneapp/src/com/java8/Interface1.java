package com.java8;

interface Interface0 {
	
}

public interface Interface1 extends Interface0 {

	default void log() {
		System.out.println("interface1 log");
	}

	default void log(String str) {
		System.out.println("interface1 str log "+str);
	}
	
	default String test(){
		return "interface1 default string";
	}
	
}
