package com.designpattern.BehavioralDesignPattern.strategy.Example1;

public interface Route {

	public void getDirections();
	public int getTotalDistance();
	public Enum getTraffic();
}
