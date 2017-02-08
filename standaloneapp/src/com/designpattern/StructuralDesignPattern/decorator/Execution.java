package com.designpattern.StructuralDesignPattern.decorator;

public class Execution {

	public static void main(String[] args) {
		
		SatelliteTV satelliteTV = new Espn(new CartoonNetwork(new SkyTV()));
		satelliteTV.show(105);
		System.out.println(satelliteTV.subscriptionPice());
		
		SatelliteTV satelliteTV2 = new Espn(new Discovery(new CartoonNetwork(new SkyTV())));
		satelliteTV2.show(208);
		System.out.println(satelliteTV2.subscriptionPice());
	}
}
