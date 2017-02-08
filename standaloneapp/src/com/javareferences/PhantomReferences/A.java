package com.javareferences.PhantomReferences;

//The objects which are being referenced by phantom references are eligible for garbage collection. But,
//before removing them from the memory, JVM puts them in a queue called ‘reference queue’ . 
//They are put in a reference queue after calling finalize() method on them. 
//You can’t retrieve back the objects which are being phantom referenced. 
//That means calling get() method on phantom reference always returns null.
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;

public class A {

}

class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();      //Strong Reference
 
        //Creating ReferenceQueue
 
        ReferenceQueue<A> refQueue = new ReferenceQueue<A>();
 
        //Creating Phantom Reference to A-type object to which 'a' is also pointing
 
        PhantomReference<A> phantomA = new PhantomReference<A>(a, refQueue);
 
        a = null;    //Now, A-type object to which 'a' is pointing earlier is available for garbage collection. But, this object is kept in 'refQueue' before removing it from the memory.
 
        a = phantomA.get();    //it always returns null
    }
}
