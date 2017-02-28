package object;

public class ObjectMethodsMain implements IObjectMethods {
	public static void main(String[] args) {
		IObjectMethods io = new ObjectMethodsMain();
		System.out.println(io.toString());
		
		System.out.println(
				new IObjectMethods() {
				}.toString()
				);
		
		
	}
}
