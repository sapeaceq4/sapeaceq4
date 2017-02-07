package com.sapient.usecases.enums;

public class NewSolarSystemTest {

	public static void main(String[] args) {
		for (Planets c : Planets.values()) {

			System.out.println("Name of the palnet - " + c + " and its density is - " + c.calculateDensity());
		}
	}
}
