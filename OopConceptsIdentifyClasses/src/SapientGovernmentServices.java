import java.util.ArrayList;
import java.util.List;

public class SapientGovernmentServices extends Sapient {

	List<Project> projects;
	public SapientGovernmentServices() {
		projects = new ArrayList<Project>();
	}
	
	void addProjects(List<Project> projectList) {
		System.out.println("SapientGovernmentServices#addProjects");
		projects.addAll(projectList);
	}
}
