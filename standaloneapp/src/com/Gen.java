package com;

public class Gen {

	G g;
	
	Gen(G g) {
		this.g=g;
	}
	
	public static void main(String[] args) {
		Gen gen[] = new Gen[5];
		/*gen[0] = new Gen("java");
		gen[1] = new Gen(1);
		gen[2] = (Gen)new Gen("1");
		gen[3] = (Gen)new Gen("1");
		
		for (Gen gen2 : gen) {
			System.out.println(gen2);
		}*/
	}
}
