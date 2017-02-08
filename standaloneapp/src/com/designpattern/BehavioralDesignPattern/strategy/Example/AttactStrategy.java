package com.designpattern.BehavioralDesignPattern.strategy.Example;

public class AttactStrategy implements TeamStrategy {

	@Override
	public void play(String team) {
		System.out.println(team+" Team will play the role of Attack!");
	}
}
