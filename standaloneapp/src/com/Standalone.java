package com;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Standalone {

	static int i = 1;

	public static void main(String[] args) {

		AssertionError t;
		try {

		} catch (Error e) {
			e.printStackTrace();
		}

		System.out.println(new Long(3 + 4) + "");

		System.out.println(new Standalone().getValue());
		System.out.println(i++);
		System.out.println("");
		System.out.println(++i);

		System.out.println("max " + Math.max(8, 3));

		ReferenceQueue<Standalone> softRefQues = new ReferenceQueue<>();
		ReferenceQueue<Standalone> weakRefQue = new ReferenceQueue<>();

		SoftReference<Standalone> softRef = new SoftReference<Standalone>(new Standalone(), softRefQues);
		WeakReference<Standalone> wr = new WeakReference<Standalone>(new Standalone(), weakRefQue);

		System.out.println("soft ref " + softRef + " wr " + wr);
	}

	public String getValue() {
		String str;
		try {
			str = "a";
			// return "b";
		} catch (Exception e) {
			str = "c";
		} finally {
			str = "d";
		}
		return str;
	}
}