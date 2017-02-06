package data.session.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	
	private static Map<Integer, String> employeeMap = new HashMap<Integer, String>();;

	public static void main(String[] args) {
		employeeMap.put(1, "Employee1");
		employeeMap.put(2, "Employee2");
		employeeMap.put(3, "Employee3");
		employeeMap.put(4, "Employee4");
		employeeMap.put(5, "Employee5");
		
		printEmployeeId(employeeMap);
		deletePrintEmployeeId(employeeMap);

	}
	
	public static void printEmployeeId(Map<Integer,String> employeeData) {
		Set<Integer> keys = employeeData.keySet();
		System.out.println("Emplyee Id's are -");
		for(Integer id : keys) {
			System.out.println(id);
		}
	}
	
	public static void deletePrintEmployeeId(Map<Integer,String> employeeData) {
		if(employeeData.containsKey(4))
			employeeData.remove(4);
		Set<Integer> keys = employeeData.keySet();
		System.out.println("Emplyee Id's after deleting id 4 are -");
		for(Integer id : keys) {
			System.out.println(id);
		}
	}

}
