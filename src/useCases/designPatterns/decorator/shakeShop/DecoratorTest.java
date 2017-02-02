package useCases.designPatterns.decorator.shakeShop;

public class DecoratorTest  {

	public static void main(String[] args) {

		
		Shake shake1 = new ShakeDecoratorWithIceCream(new MangoShake());
		System.out.println(shake1.getDescription());
		System.out.println(shake1.getCost());
		Shake shake2 = new ShakeDecoratorWithIceCream(new BananaShake());
		
		
		System.out.println(shake2.getDescription());
		System.out.println(shake2.getCost());
	}	

}
