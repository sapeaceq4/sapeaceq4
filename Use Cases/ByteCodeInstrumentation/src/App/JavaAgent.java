package App;

import java.lang.instrument.Instrumentation;

public class JavaAgent {
	public static void premain(String args, Instrumentation inst) {
		System.out.println("Java Agent");
		TestIns obj = new TestIns();
		long size = inst.getObjectSize(obj);
		System.out.println("Bytes used by object: " + size);
	}
}
