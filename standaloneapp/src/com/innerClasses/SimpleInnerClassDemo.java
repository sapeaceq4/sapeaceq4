package com.innerClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SimpleInnerClassDemo {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public class inner {
		public String getInnerString() {
			return "innername";
		}
	}

	public static void main(String[] args) {
		SimpleInnerClassDemo demo = new SimpleInnerClassDemo();
		demo.new inner();

		List<SimpleInnerClassDemo> list = new ArrayList<SimpleInnerClassDemo>();

		list.sort(new Com1().thenComparing(new Com2()));
		
		//list.sort((a,b) -> a.getName());
	}
}

class Com1 implements Comparator<SimpleInnerClassDemo> {

	@Override
	public int compare(SimpleInnerClassDemo o1, SimpleInnerClassDemo o2) {
		return o1.getId() - o2.getId();
	}
}

class Com2 implements Comparator<SimpleInnerClassDemo> {

	@Override
	public int compare(SimpleInnerClassDemo o1, SimpleInnerClassDemo o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
