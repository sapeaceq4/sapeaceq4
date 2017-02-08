package com.designpattern.StructuralDesignPattern.flyweight.ex1;

import java.util.HashMap;

public class ShapeFactory {

	private static final HashMap<String, Shape> hashmap = new HashMap<>();
	
	public static Shape getShape(String shapeType){
		Shape shape = null;
		if("circle".equalsIgnoreCase(shapeType)){
				shape = new Circle("Red", 1, 1);
		}else{
			//another circle object
		}
		return shape;
	}
}
