package com.sapient.ACE.Aspect;

public class DaoIntercepter {

	public void beforeDaoMethods() {
		System.out.println("beforeDaoMethods");
	}

	public void aroundDaoMethods() {
		System.out.println("aroundDaoMethods");
	}
}
