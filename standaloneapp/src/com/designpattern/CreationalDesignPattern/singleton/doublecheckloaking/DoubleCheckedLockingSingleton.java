package com.designpattern.CreationalDesignPattern.singleton.doublecheckloaking;

public class DoubleCheckedLockingSingleton {

	private static DoubleCheckedLockingSingleton instance;

	private DoubleCheckedLockingSingleton() {
	}

	public static synchronized DoubleCheckedLockingSingleton getInstance() {
		if (instance == null) {
			synchronized(DoubleCheckedLockingSingleton.class){
				if (instance == null) {
					instance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return instance;
	}
}
