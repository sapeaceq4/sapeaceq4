package com.javareferences.SoftReferences;

import java.lang.ref.SoftReference;

public class A
{
    //A Class
}
 
class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();      //Strong Reference
 
        //Creating Soft Reference to A-type object to which 'a' is also pointing
 
        SoftReference<A> softA = new SoftReference<A>(a);
 
        a = null;    //Now, A-type object to which 'a' is pointing earlier is eligible for garbage collection. But, it will be garbage collected only when JVM needs memory.
 
        a = softA.get();    //You can retrieve back the object which has been softly referenced
    }
}
