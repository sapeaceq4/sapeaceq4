package collections.enums;

public class NewSolarSystemTest {
	public static void main(String[] args) {
		
		for(Planet p: Planet.values()){
			System.out.println("Name: "+p+"; density: "+p.density());
		}
	}
}
