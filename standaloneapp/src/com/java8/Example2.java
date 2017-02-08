package com.java8;

import java.util.Optional;

public class Example2 implements Interface1, Interface2 {

	public static void main(String[] args) {
		
		System.out.println(Integer.compare(1, 3));
		
		Optional<String> value = Optional.of("Shailendra");
		
		value.isPresent();
		
	}
}