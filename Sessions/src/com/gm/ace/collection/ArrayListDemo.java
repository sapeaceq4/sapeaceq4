package com.gm.ace.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;

public class ArrayListDemo {
	public static void main(String[] args)
    {    Queue<Integer> i;
    	Set<Object> objects = new HashSet<Object>();
    	Comparable<Object> comparable;
    	Comparator<Object> comparator;
        ArrayList<String> list = new ArrayList<String>();
         
        list.add("ONE");
         
        list.add("TWO");
         
        list.add("THREE");
         
        list.add("FOUR");
        
         
        ListIterator iterator = list.listIterator();
         
        System.out.println("Elements in forward direction");
         
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
         
        System.out.println("Elements in backward direction");
         
        while (iterator.hasPrevious())
        {
            System.out.println(iterator.previous());
        }
        
        System.out.println( allocateElements(-100));
        
        
        
    }
	
	private static int allocateElements(int numElements) {
        int initialCapacity = 8;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        return initialCapacity;
	}
}
