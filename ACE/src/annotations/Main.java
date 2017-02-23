package annotations;

public class Main {
	public static void main(String[] args) {
		Employee e = new Employee();
	}
}

@AuthorAnnotation(authorName = "author", emailId = "email")
class Employee {
	
}