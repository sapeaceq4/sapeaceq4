package useCases.designPatterns.decorator.shakeShop;

public class BananaShake implements Shake {
	
	
	@Override
	public String getDescription() {
		return "Banana";
	}

	@Override
	public double getCost() {
		return 20;
	}
}
