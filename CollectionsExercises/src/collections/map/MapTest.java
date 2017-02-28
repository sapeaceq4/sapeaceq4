package collections.map;

import java.util.HashMap;
import java.util.Map;


public class MapTest {
	public static void main(String[] args) {
		Map<Integer,String> employees = new HashMap<>();
		
		//Steve Rob Peter Mark John Tom
		employees.put(1, "Steve");
		employees.put(2, "Rob");
		employees.put(3, "Peter");
		employees.put(4, "Mark");
		employees.put(5, "John");
		employees.put(6, "Tom");
		System.out.println(employees);
		
		employees.remove(4);
		System.out.println(employees);
		
	}
}
