package com.multithread.countdownlatch.exp1;

public class Main {

	public static void main(String[] args) {
		boolean result = false;
		try {
			result = ApplicationStartupUtil.checkForExternalServices();
			
		} catch (Exception e) {
		}
		System.out.println("External services validation completed !! Result was :: "+ result);
	}
}
