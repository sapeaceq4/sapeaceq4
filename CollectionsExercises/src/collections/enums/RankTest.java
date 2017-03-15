package collections.enums;

public class RankTest {
	public static void main(String[] args) {
		for(Rank r: Rank.values())
			System.out.println(r+"("+r.value+")");
	}
}

enum Rank {
	DEUCE
	,THREE
	,FOUR
	,FIVE
	,SIX
	,SEVEN
	,EIGHT
	,NINE(2)
	,TEN(1)
	,JACK(3)
	,QUEEN
	,KING
	,ACE(1);
	
	Rank(int value) {
		this.value= value;
	}
	Rank() {
		this.value = 0;
	}
	
	int value;
}