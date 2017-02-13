package com.sapient.usecases.enums;

public enum Planets {
		MERCURY (3.303e+23, 1.409e6),
		VENUS   (4.869e+24, 6.0518e6),
		EARTH   (5.976e+24, 6.37814e6),
		MARS    (6.421e+23, 3.3972e6),
		JUPITER (1.9e+27,   7.1492e7),
		SATURN  (5.688e+26, 6.0268e7),
		URANUS  (8.686e+25, 2.5559e7),
		NEPTUNE (1.024e+26, 2.4746e7);
	
		private final double mass; 
		private final double volume; 
		Planets(double mass, double volume) {
		this.mass = mass;
		this.volume = volume;
		}
		
		private double mass() { return mass; }
		private double volume() { return volume; }
		
		double calculateDensity() {
		return mass / volume;
		}
}