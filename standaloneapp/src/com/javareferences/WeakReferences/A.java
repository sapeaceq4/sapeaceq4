package com.javareferences.WeakReferences;

import java.lang.ref.WeakReference;

public class A {

}

class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();      //Strong Reference
 
        //Creating Weak Reference to A-type object to which 'a' is also pointing.
 
        WeakReference<A> weakA = new WeakReference<A>(a);
 
        a = null;    //Now, A-type object to which 'a' is pointing earlier is available for garbage collection.
 
        a = weakA.get();    //You can retrieve back the object which has been weakly referenced.
    }
}
