package useCases.designPatterns.decorator.shakeShop;

public class MangoShake implements Shake {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Mango";
	}

	@Override
	public double getCost() {
		return 30;
	}

}
