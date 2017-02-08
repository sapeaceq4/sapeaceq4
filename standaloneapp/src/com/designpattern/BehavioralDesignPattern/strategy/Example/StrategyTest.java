package com.designpattern.BehavioralDesignPattern.strategy.Example;

public class StrategyTest {

	public static void main(String[] args) {

		Team teamGermony = new TeamGermony();
		Team teamArgentina = new TeamArgentina();

		// Strategy for both the team below

		TeamStrategy attackStrategy = new AttactStrategy();
		TeamStrategy defenceStrategy = new DefenceStrategy();

		//Germany starts the game with defence mode
		//Argentina starts the game with attack mode
		
		teamArgentina.setTeamStrategy(attackStrategy);
		teamGermony.setTeamStrategy(defenceStrategy);

		teamGermony.setTeamName("Germany");
		teamArgentina.setTeamName("Argentina");
		
		teamArgentina.teamInfo();
		teamArgentina.playGame();
		
		teamGermony.teamInfo();
		teamGermony.playGame();
	
		
	}
}
