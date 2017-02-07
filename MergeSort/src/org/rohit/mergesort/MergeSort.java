package org.rohit.mergesort;

import java.util.ArrayList;

public class MergeSort<E extends Comparable> {
	
	private ArrayList<E> data;
	
	public MergeSort(ArrayList<E> data) {
		this.data = data;
	}

	public ArrayList<E> sort(ArrayList<E> data)
	{
		int size = data.size();
		if(size == 1) return data;
		int middle = size/2;
		ArrayList<E> firsthalf = new ArrayList<>(data.subList(0,middle));
		ArrayList<E> secondhalf =  new ArrayList<>(data.subList(middle,size));
		firsthalf = sort(firsthalf);
		secondhalf = sort(secondhalf);
		data = merge(firsthalf, secondhalf);
		return data;
	}
	
	public ArrayList<E> merge(ArrayList<E> firstHalf , ArrayList<E> secondHalf)
	{
		int fi = 0, si = 0, mi;
		ArrayList<E> result = new ArrayList<>();
		while(fi < firstHalf.size() && si < secondHalf.size())
		{
			if(firstHalf.get(fi).compareTo(secondHalf.get(si)) >= 0)
			{
				result.add(secondHalf.get(si));
				si++;
			}
			else
			{
				result.add(firstHalf.get(fi));
				fi++;
			}
		}
		
		while(fi<firstHalf.size())
		{
			result.add(firstHalf.get(fi));
			fi++;
		}
		
		while(si< secondHalf.size())
		{
			result.add(secondHalf.get(si));
			si++;
		}
		
		return result;
	}
	
	
}
