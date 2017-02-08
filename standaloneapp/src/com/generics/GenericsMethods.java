package com.generics;

public class GenericsMethods {

	public static <T> boolean isEqual(GenericsTypeClass<T> g1, GenericsTypeClass<T> g2){
		return g1.get().equals(g2.get());
	}
	
}
