public class Test {
	public static void main(String[] args) {
		final int i = 9;
		B k = new B();
		System.out.println(C.a);
		System.out.println(WalkManCounter.getNextCount());
		System.out.println(WalkManCounter.getNextCount());
		new C();
		D io = new E();
		new B();
	}
}

class A {
	static int h = 9;

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
}

class B extends A {
	static int h = 10;

	B() {
		super(9);
	}

	B(int i) {
		this();
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

class E implements D {
	void print() {
		System.out.println("E akash");
	}
}