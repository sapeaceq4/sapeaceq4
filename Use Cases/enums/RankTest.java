package com.ace.enums;

import java.util.EnumMap;

public class RankTest {
	public static void main(String[] args) {
		EnumMap<Rank, Integer> map = new EnumMap<Rank, Integer> (Rank.class);
		map.put(Rank.JACK, 3);
		map.put(Rank.NINE, 2);
		map.put(Rank.ACE, 1);		
	}
	
}

enum Rank {
	DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
}
