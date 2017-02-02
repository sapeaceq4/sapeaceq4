package com.gm.ace.polymorphism;

interface Ai {
	
}

interface Bi extends Ai{
	
}

interface Ci {
	
}

class Di implements Bi,Ci{
	
}

public class InterfaceOverloading {
	static void overloadedMethod(Ai a)
    {
        System.out.println("ONE");
    }
         
    static void overloadedMethod(Object obj)
    {
        System.out.println("THREE");
    }
    
    static void overloadedMethod(Bi b)
    {
        System.out.println("TWO");
    }
    
    static void overloadedMethod(Ci b)
    {
        System.out.println("Four");
    }
    
    public static void main(String[] args) {
		Ai a = new Di();
		overloadedMethod(a);
		
		Di d = new Di();
//		overloadedMethod(d);
	}
    
    
}
