package com.generics;

public class GenericsTypeClass<T> {

	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		GenericsTypeClass<String> genericsTypeClass = new GenericsTypeClass<>();
		genericsTypeClass.set("Shailendra");
	}
}
