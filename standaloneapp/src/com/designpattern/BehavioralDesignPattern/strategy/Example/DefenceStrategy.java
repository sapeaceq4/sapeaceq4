package com.designpattern.BehavioralDesignPattern.strategy.Example;

public class DefenceStrategy implements TeamStrategy {

	@Override
	public void play(String team) {
		System.out.println(team+" Team will play in defence!!");
	}
}