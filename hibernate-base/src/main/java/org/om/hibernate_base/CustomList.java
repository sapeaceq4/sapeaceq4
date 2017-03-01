package org.om.hibernate_base;

import java.util.Iterator;
import java.util.Objects;

public class CustomList<E> implements Iterable<E>
{
	private static final int DEFAULT_SIZE = 10;
	private Object[] elements;
	private int count = 0;
	
	public CustomList()
	{
		this(DEFAULT_SIZE);
	}

	public CustomList(int size)
	{
		elements = new Object[size];
	}
	
	public void add(E element)
	{
		Objects.requireNonNull(element);
		if(elements.length >= count)
		{
			Object[] newElements = new Object[elements.length*2];
			System.arraycopy(elements, 0, newElements, 0, elements.length);
			elements = newElements;
		}
		elements[count++] = element;
	}
	
	@Override
	public Iterator<E> iterator()
	{
		return new Itr();
	}
	
	class Itr implements Iterator<E>
	{
		private int currentCurssor;
		
		@Override
		public boolean hasNext() 
		{
			return currentCurssor < count ? true : false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() 
		{
			return (E)elements[currentCurssor++];
		}
		
	}
	
	public static void main(String[] args)
	{
		CustomList<Integer> customList = new CustomList<Integer>();
		customList.add(1);
		customList.add(2);
		customList.iterator();
		
		for (Integer integer : customList) 
		{
			System.out.println(integer);
		}
	}
}
