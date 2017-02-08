package com.designpattern.StructuralDesignPattern.decorator;

public class CartoonNetwork extends ChannelDecorator {

	public CartoonNetwork(SatelliteTV satelliteTV) {
		super(satelliteTV);
	}
	
	@Override
	public void show(int channelNumber) {
		if(channelNumber>100 && channelNumber<150){
			System.out.println("Enjoy Cartoon Network");
		}else{
			this.getSatelliteTV().show(channelNumber);
		}
	}

	@Override
	public int subscriptionPice() {
		return getSatelliteTV().subscriptionPice()+9;
	}

}
