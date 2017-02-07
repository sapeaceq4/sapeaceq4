package com.sapient.ace.corejava.collections;

public class Walkman {
	private static int nextSerialNo = 1;
	private int serialNo;

	public Walkman(int serialNo) {
		this.serialNo = serialNo;

	}

	public static int getNextSerialNo() {
		return nextSerialNo++;

	}

	public int getSerialNo() {
		return serialNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Walkman other = (Walkman) obj;
		if (serialNo != other.serialNo)
			return false;
		return true;
	}
}
