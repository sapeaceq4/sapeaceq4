package useCases.designPatterns.decorator.shakeShop;

public abstract class ShakeDecorator implements Shake {

	protected Shake shake;

	public ShakeDecorator(Shake shake) {
		this.shake=shake;
	}
	@Override
	public String getDescription() {
		return shake.getDescription();
	}

	@Override
	public double getCost() {
		return shake.getCost();
	}

}
