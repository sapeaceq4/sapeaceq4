import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Maptest {

	public static void main(String[] args) {
		 
		 		Map<Integer, String> empMap = new HashMap<>();
		 	
			  Employee e1 = new Employee(001, "Steve");
		 	  Employee e2 = new Employee(002, "Rob");
				Employee e3 = new Employee(003, "Peter");
				Employee e4 = new Employee(004, "Mark");
				Employee e5 = new Employee(005, "John");
		 		Employee e6 = new Employee(006, "Tom");
		 	
		 		
		 		empMap.put(e1.getId(), e1.getName());
		 		empMap.put(e2.getId(), e2.getName());
		 	empMap.put(e3.getId(), e3.getName());
		 	empMap.put(e4.getId(), e4.getName());
		 		empMap.put(e5.getId(), e5.getName());
		 		empMap.put(e6.getId(), e6.getName());
		 		
		 		Set<Integer> keySet = empMap.keySet();
		 		
		 		for(Integer key : keySet){
		 			System.out.println(key);
		 		}
		 		
		 		empMap.remove(004);
		 		
		 		keySet = empMap.keySet();
		 		for(Integer key : keySet){
		 			System.out.println(key);
		 		}
		 		
		 	}
	
	
}
