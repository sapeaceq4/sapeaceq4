public class StaticTest {

	public static int s2 = val();

	static int val() {
		return s1;
	}

	public static int s1 = 9;

	public static void main(String[] args) {
		System.out.println(s2);
	}
}