import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		final int i = 9;
		B k = new B();
		System.out.println(C.a);
		System.out.println(WalkManCounter.getNextCount());
		System.out.println(WalkManCounter.getNextCount());
		new C();
		D io = new E();
		B obj = new B();
		ObjectOutputStream ko = new ObjectOutputStream(new FileOutputStream(
				".\\resource\\file.ser"));
		ko.writeObject(obj);
		ko.close();

		ObjectInputStream ino = new ObjectInputStream(new FileInputStream(
				".\\resource\\file.ser"));
		System.out.println(ino.readObject());
		ino.close();

		List li = new ArrayList<Integer>();

		li.add(2);
		li.add(2.4);
		li.add(4.5);
		li.add(5.6);
		li.add("akash");

		for (int ki = 0; ki < li.size(); ki++) {
			System.out.println(li.get(ki));
		}

	}
}

class A implements Serializable {
	static int h = 9;

	private int jk = 9;

	A() {
		System.out.println("A Cons");
	}

	A(int i) {
		this();
		System.out.println(i);
	}

	Number pri() {
		return 1;
	}

	@Override
	public String toString() {
		return "A [jk=" + jk + "]";
	}
}

class B extends A {
	static int h = 10;
	private int jko = 9;

	transient Thread t = new Thread();

	B() {
		super(9);
	}

	B(int i) {
		this();
	}

	@Override
	public String toString() {
		return super.toString() + "B [jko=" + jko + "]";
	}

	@Override
	Integer pri() {
		return 1;
	}
}

class C {
	static int a = getB();
	static int b = 10;

	{
		System.out.println("akash");
	}

	{
		System.out.println("akash");
	}

	C() {
		System.out.println("alok");
	}

	static int getB() {
		return b;
	}
}

interface D {
	static void print() {
		System.out.println("akash");
	}

	default void print1() {
		System.out.println("akash");
	}
}

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE })
@interface AuthorInfo {
	public String authorName();
	public String emailId();
	public String empType() default "permament";
}

class E implements D {
	void print() {
		System.out.println("E akash");
	}
}