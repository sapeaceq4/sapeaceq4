package com.gm.ace;

import java.io.ObjectStreamException;
import java.io.Serializable;


public class DesignPattern {

}

class SingleDesignPattern implements Serializable{

	private static final long serialVersionUID = -3848789968621214257L;
	
	private static volatile SingleDesignPattern INSTANCE = null;

	private SingleDesignPattern() {
	}

	public static SingleDesignPattern getInstance() {
		synchronized (INSTANCE) {
			if (INSTANCE == null) {
				synchronized (INSTANCE) {
					INSTANCE = new SingleDesignPattern();
				}
			}
		}
		return INSTANCE;
	}
	
	protected Object readResolve() throws ObjectStreamException{
		return INSTANCE;
	}
}
