public class WalkManCounter {

	private static int count;
	private static Object lock = new Object();

	private WalkManCounter() {
	}

	public static int getNextCount() {
		synchronized (lock) {
			return ++count;
		}
	}
}
