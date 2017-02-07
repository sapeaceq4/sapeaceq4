import java.util.ArrayList;
import java.util.List;

public class SapientGlobalMarkets extends Sapient {

	List<Project> projects;
	
	public SapientGlobalMarkets() {
		projects = new ArrayList<Project>();
	}
	
	void addProjects(List<Project> projectList) {
		System.out.println("SapientGlobalMarkets#addProjects");
		projects.addAll(projectList);
	}
}
