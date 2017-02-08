package com.designpattern.CreationalDesignPattern.singleton.LazyInitialization;

public class LazyInitializedSingleton {

	private static LazyInitializedSingleton initializedSingleton;

	private LazyInitializedSingleton() {
		// TODO Auto-generated constructor stub
	}

	public static LazyInitializedSingleton getInstance() {
		if (initializedSingleton == null) {
			initializedSingleton = new LazyInitializedSingleton();
		}
		return initializedSingleton;
	}
}
