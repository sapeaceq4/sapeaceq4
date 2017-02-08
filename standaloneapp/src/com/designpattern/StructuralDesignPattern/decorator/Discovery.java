package com.designpattern.StructuralDesignPattern.decorator;

public class Discovery extends ChannelDecorator {

	public Discovery(SatelliteTV satelliteTV) {
		super(satelliteTV);
	}

	@Override
	public void show(int channelNumber) {
		if(channelNumber>300 && channelNumber<400){
			System.out.println("Annimal Documentary");
		}else{
			this.getSatelliteTV().show(channelNumber);
		}
	}

	@Override
	public int subscriptionPice() {
		return this.getSatelliteTV().subscriptionPice() + 6;
	}

}
