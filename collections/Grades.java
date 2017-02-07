package com.sapient.ace.corejava.collections;

public enum Grades {
	A("Topper"), B("Average"), C("Poor"), F("Fail");

	private String value;

	public String getValue() {
		return value;
	}

	Grades(String value) {
		this.value = value;
	}

}
