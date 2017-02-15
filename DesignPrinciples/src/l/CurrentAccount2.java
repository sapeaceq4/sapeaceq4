package l;

public class CurrentAccount2 extends Account {

	public CurrentAccount2(int bal, int per) {
		super(bal, per);
	}

	@Override
	public boolean closeAccount() {
		if(balance > 0)
			return true;
		return false;
	}

}
