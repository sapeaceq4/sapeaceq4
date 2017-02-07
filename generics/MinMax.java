package com.sapient.ace.corejava.generics;

public class MinMax<min, max> {
	private min first;
	private max second;

	public MinMax(min first, max second) {
		this.first = first;
		this.second = second;
	}

	public MinMax() {
	}

	public void setFirst(min first) {
		this.first = first;
	}

	public void setSecond(max second) {
		this.second = second;
	}

	public min getFirst() {
		return this.first;
	}

	public max getSecond() {
		return this.second;
	}
}
