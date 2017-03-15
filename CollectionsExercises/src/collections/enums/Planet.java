package collections.enums;

public enum Planet {
	MARS(3.285 * Math.pow(10,23),2440.0), VENUS(48.67 * Math.pow(10,23),6052.0), EARTH(59.72 * Math.pow(10,23),6371.0);
	
	Planet(double mass, double volume) {
		this.mass = mass;
		this.volume = volume;
	}
	
	double mass;
	double volume;
	
	public double density() {
		return mass/volume;
	}
}
