package com.annotation;

public class LoopTest {

	public static void main(String[] args) {
		outerLoop: for (int i = 0; i < 10; i++) {
			innerLoop: for (int j = 10; j < 20; j++) {
				break outerLoop;

			}
		}

	}
}
