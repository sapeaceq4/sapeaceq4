package com.javareferences.StrongReferences;

public class A
{
    //Class A
}
 
class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();      //Strong Reference
 
        a = null;    //Now, object to which 'a' is pointing earlier is eligible for garbage collection.
    }
}
