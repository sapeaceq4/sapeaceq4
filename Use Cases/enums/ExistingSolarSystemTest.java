package com.ace.enums;

import java.util.EnumSet;

public class ExistingSolarSystemTest {

	public static void main(String[] args) {
		EnumSet<Planets> planets = EnumSet.range(Planets.MERCURY, Planets.NEPTUNE);
		for (Planets c : planets) {

			System.out.println("Name of the palnet - " + c + " and its density is - " + c.calculateDensity());
		}
	}
}
