package safari;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String[] animals = new String[] {
			"Cat","Deer","Dog","Elephant","Lion","Tiger"	
		};
		
			Animal animal = new Elephant();
			animal.speak();
		
	}
}
