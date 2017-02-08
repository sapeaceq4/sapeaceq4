package com;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B implements Serializable{
	
	A a = new A();
	
	public static void main(String[] args) {
		B b = new B();
		try {

			FileOutputStream fs = new FileOutputStream("b.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(b);
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
