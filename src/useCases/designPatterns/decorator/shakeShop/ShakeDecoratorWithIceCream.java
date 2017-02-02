package useCases.designPatterns.decorator.shakeShop;

public class ShakeDecoratorWithIceCream extends ShakeDecorator{

	
	public ShakeDecoratorWithIceCream(Shake shake) {
		super(shake);
	}
	
	@Override
	public String getDescription() {
		return shake.getDescription()+", with icecream";
	}

	@Override
	public double getCost() {
		return shake.getCost()+15;
	}

}
