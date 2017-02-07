package com.sapient.ace.corejava.collections;

import com.sapient.ace.corejava.collections.Walkman;

public class WalkManTest {

	public static void main(String[] args) {

		Walkman wm1 = new Walkman(Walkman.getNextSerialNo());
		System.out.println(wm1.getSerialNo());
		Walkman wm2 = new Walkman(Walkman.getNextSerialNo());
		System.out.println(wm2.getSerialNo());
		Walkman wm3 = new Walkman(Walkman.getNextSerialNo());
		System.out.println(wm3.getSerialNo());
	}

}
