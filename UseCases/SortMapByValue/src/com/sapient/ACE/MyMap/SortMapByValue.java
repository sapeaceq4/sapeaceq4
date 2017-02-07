package com.sapient.ACE.MyMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {

	
	public static void main(String[] args) {

		Map<Integer,String> hashMap= new HashMap<>();
		hashMap.put(1,"Amanjot");
		hashMap.put(2,"Singh");
		hashMap.put(3,"DDDDDD");
		hashMap.put(4,"XXXXXX");
		hashMap.put(7,"MMMMMM");
		hashMap.put(10,"PPPPPP");
		
		Set<Integer> setKey= hashMap.keySet();
		 List<Entry<Integer, String>> list = new ArrayList<Entry<Integer, String>>(hashMap.entrySet());
	        Collections.sort( list, new Comparator<Map.Entry<Integer,String>>()
	        {
	            public int compare( Map.Entry<Integer,String> o1, Map.Entry<Integer,String> o2 )
	            {
	                return (o2.getValue()).compareTo( o1.getValue() );
	            }
	        } );
	        for(Entry<Integer, String> entry:list){
	            System.out.println(entry.getKey()+" ==== "+entry.getValue());
	        }
		
	}

}
