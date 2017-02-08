package com.designpattern.StructuralDesignPattern.decorator;

public class SkyTV implements SatelliteTV{

	
	@Override
	public void show(int channelNumber) {
		if(channelNumber<100){
			System.out.println("Basic Channel");
		}else{
			System.out.println("You are not subscribed - Please subscribe");
		}
	}
	
	@Override
	public int subscriptionPice() {
		return 100;
	}
}
