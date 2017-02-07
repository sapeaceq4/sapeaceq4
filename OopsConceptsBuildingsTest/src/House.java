
public class House extends Building {

	@Override
	protected void approvalRequired() {
		System.out.println("approval from LUDA required");
	}

}
