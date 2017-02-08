package com.arraylist;

import java.util.Arrays;

public class CustomArrayList<E> {

	private static final int DEFAULT_INITIAL_CAPACITY  =5;
	
	private static final Object[] EMPTY_ELEMENT_DATA  = {};
	
	private int size;
	
	private transient Object[] customArrayListElementData;
	
	public CustomArrayList(int initialCapacity){
		super();
		if(initialCapacity<0){
			throw new IllegalArgumentException("Illegal Capacity "+initialCapacity);
		}
		this.customArrayListElementData = new Object[initialCapacity];
	}
	
	public CustomArrayList(){
		super();
		this.customArrayListElementData = EMPTY_ELEMENT_DATA;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public boolean add(E e){
		ensureCapacity(size+1);
		customArrayListElementData[size++] = e;
		return true;
	}

	private void ensureCapacity(int minCapacity) {
		if(customArrayListElementData==EMPTY_ELEMENT_DATA){
			minCapacity  = Math.max(minCapacity, DEFAULT_INITIAL_CAPACITY);
		}
		if(minCapacity-customArrayListElementData.length>0){
			growCustomArrayList(minCapacity);
		}
	}

	private void growCustomArrayList(int minCapacity) {
		int oldCapacity = customArrayListElementData.length;
		int newCapacity = oldCapacity+(oldCapacity/2);
		if(newCapacity-minCapacity<0){
			newCapacity = minCapacity;
			customArrayListElementData = Arrays.copyOf(customArrayListElementData, newCapacity);
		}
	}
	
	public static void main(String[] args) {
		CustomArrayList<String> arraylist = new CustomArrayList<>();
		arraylist.add("str2");
		arraylist.add("sdas");
		
		System.out.println("size "+arraylist.size);
	}
	
	public void clear(){
		
	}
}
