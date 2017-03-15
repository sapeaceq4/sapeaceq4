package collections.enums;

import java.util.EnumSet;

public class ExistingSolarSystemTest {
	public static void main(String[] args) {
		EnumSet<Planet> set = EnumSet.allOf(Planet.class);
		
		for(Planet p: set) {
			System.out.println("Name: "+p+"; density: "+p.density());
		}
	}
}
