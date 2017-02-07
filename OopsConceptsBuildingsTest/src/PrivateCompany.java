
public class PrivateCompany extends Company {

	@Override
	protected void approvalRequired() {
		System.out.println("approval form LUDA and promoters required");
	}
	
}
