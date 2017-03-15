package collections.enums;

public class SuitTest {
	public static void main(String[] args) {
		for(Suit s: Suit.values())
			System.out.println(s);
	}
}

enum Suit {
	SPADES, HEARTS, DIAMONDS, CLUBS;
	
}