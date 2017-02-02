package com.gm.ace.polymorphism;

class A
{
     
}
 
class B extends A
{
     
}
 
class C extends B
{
     
}
 
public class ObjectOverloading 
{
    static void overloadedMethod(A a)
    {
        System.out.println("ONE");
    }
         
    static void overloadedMethod(Object obj)
    {
        System.out.println("THREE");
    }
    
    static void overloadedMethod(B b)
    {
        System.out.println("TWO");
    }
     
     
    public static void main(String[] args)
    {
        C c = new C();
         
        overloadedMethod(c);
        
        A a = new A();
        
        overloadedMethod(a);
        
        A a1 = new C();
        
        overloadedMethod(a1);
        
        Object o = new C();
        
        overloadedMethod(o);
        
    }
}