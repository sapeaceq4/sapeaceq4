import java.util.ArrayList;
import java.util.List;

public class SapientNitro extends Sapient {

	List<Project> projects;

	public SapientNitro() {
		projects = new ArrayList<Project> ();
		
	}
	void addProjects(List<Project> projectList) {
		System.out.println("SapientNitro#addprojects");
		projects.addAll(projectList);
	}
}
