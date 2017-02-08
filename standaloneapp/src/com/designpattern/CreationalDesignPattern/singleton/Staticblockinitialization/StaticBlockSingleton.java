package com.designpattern.CreationalDesignPattern.singleton.Staticblockinitialization;

public class StaticBlockSingleton {

	private static StaticBlockSingleton BLOCK_SINGLETON;

	private StaticBlockSingleton() {
		// TODO Auto-generated constructor stub
	}

	static {
		try {
			BLOCK_SINGLETON = new StaticBlockSingleton();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static StaticBlockSingleton getInstance() {
		return BLOCK_SINGLETON;
	}
}
