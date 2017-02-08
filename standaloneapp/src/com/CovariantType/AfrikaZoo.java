package com.CovariantType;

public class AfrikaZoo extends Zoo {

	@Override
	Lion getAnimal() {
		return new Lion();
	}
}