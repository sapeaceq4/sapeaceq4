
public class PublicListedCompany extends Company {

	@Override
	protected void approvalRequired() {
		System.out.println("approval form LUDA and shareholders required");
	}
	
}
