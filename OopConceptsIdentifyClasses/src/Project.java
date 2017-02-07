import java.util.ArrayList;
import java.util.List;

public class Project {

	List<Employee> employees;
	
	public Project() {
		employees = new ArrayList<Employee> ();
	}
	
	void addEmployees(List<Employee> employeeList){
		System.out.println("Project#addEmployees");
		employees.addAll(employeeList);
	}
}
