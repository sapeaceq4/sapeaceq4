package com.designpattern.StructuralDesignPattern.flyweight.ex1;

public class Circle implements Shape{

	private String color;
	private int x;
	private int y;
	
	public Circle(String color, int x, int y) {
		this.color=color;
		this.x=x;
		this.y=y;
	}
	
	@Override
	public void draw(String color, int x, int y) {
		System.out.println(color+x+y);
	}
}
