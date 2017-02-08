package com.designpattern.StructuralDesignPattern.decorator;

public class Espn extends ChannelDecorator {

	public Espn(SatelliteTV satelliteTV) {
		super(satelliteTV);
	}

	@Override
	public void show(int channelNumber) {
		if(channelNumber>100 && channelNumber<200){
			System.out.println("Enjoy cricet match!!");
		}else{
			this.getSatelliteTV().show(channelNumber);
		}
	}

	@Override
	public int subscriptionPice() {
		return getSatelliteTV().subscriptionPice()+10;
	}

	
	
}
