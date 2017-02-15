package l;

public class TimedCurrentAccount2 extends Account {

	private int defaultPeriod;

	public TimedCurrentAccount2(int bal, int per) {
		super(bal, per);
	}

	@Override
	public boolean closeAccount() {
		if(balance > 0 && period > defaultPeriod)
			return true;
		return false;
	}

}
