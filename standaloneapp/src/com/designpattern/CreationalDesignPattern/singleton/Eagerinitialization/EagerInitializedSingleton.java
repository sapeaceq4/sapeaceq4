package com.designpattern.CreationalDesignPattern.singleton.Eagerinitialization;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton EAGER_INITIALIZED_SINGLETON = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {
		// TODO Auto-generated constructor stub
	}

	public static EagerInitializedSingleton getInstance() {
		return EAGER_INITIALIZED_SINGLETON;
	}
}
