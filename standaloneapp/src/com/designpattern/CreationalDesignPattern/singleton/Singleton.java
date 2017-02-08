package com.designpattern.CreationalDesignPattern.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {

	private static Singleton firstInstance = null;

	// Holds all scrabble letters in Array

	String[] scrableLetters = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d",
			"e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i",
			"i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n",
			"o", "o", "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s",
			"t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z" };

	private LinkedList<String> scrabbleLetterList = new LinkedList<>(Arrays.asList(scrableLetters));
	static boolean firstThread = true;

	private Singleton() {

	}

	public static synchronized Singleton getInstance() {
		if (firstInstance == null) {
			firstThread = false;
			Thread.currentThread();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Singleton.class) {
				firstInstance = new Singleton();

				Collections.shuffle(firstInstance.scrabbleLetterList);
			}
		}
		return firstInstance;
	}

	public LinkedList<String> getScrabbleLettes() {
		return firstInstance.scrabbleLetterList;
	}

	public LinkedList<String> getTiles(int howManyTiles) {
		LinkedList<String> tilesTosend = new LinkedList<>();
		for (int i = 0; i < howManyTiles; i++) {
			tilesTosend.add(firstInstance.scrabbleLetterList.remove(0));
		}
		return tilesTosend;
	}
}