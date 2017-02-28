
public class Swap {
	public static void main(String[] args) {
		int a=1;
		int b=2;
		
		Obj o = new Obj(a,b);
		
		o = swap(o);
		a = o.x;
		b = o.y;
		
		System.out.println(a+", "+b);
	}
	
	static Obj swap(Obj o) {
		int c = o.x;
		o.x = o.y;
		o.y=c;
		
		return o;
	}
}


class Obj {
	Integer x;
	Integer y;
	
	Obj(int a, int b) {
		x = a;
		y = b;
	}
}