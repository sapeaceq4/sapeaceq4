package com.designpattern.StructuralDesignPattern.decorator;

public abstract class ChannelDecorator implements SatelliteTV{

	private SatelliteTV satelliteTV;
	
	public ChannelDecorator(SatelliteTV satelliteTV) {
		this.satelliteTV=satelliteTV;
	}
	
	public SatelliteTV getSatelliteTV(){
		return satelliteTV;
	}
	
}
