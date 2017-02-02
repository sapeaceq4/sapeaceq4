package com.gm.ace.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LamdaExpresion {
	public static void main(String[] args) {
		IntFunction<Integer> f = (x) -> 42;
		Integer s = f.apply(23);
		System.out.println(s);
		
		BiFunction<Integer,Integer,Integer> sum = (x , y) -> x + y;
		System.out.println("Sum " + sum.apply(5, 10));
		
		Thread t = new Thread(() -> System.out.println("hello"));
		
		Runnable t1 = () -> System.out.println("hello");
		
		process(() -> System.out.println("hello world"));
		
		Predicate<Integer> r;
		
		List<Apple> list = new ArrayList<Apple>();
		
		//by Lambdas expression
		list.sort((a1,a2) -> (a1.getWeight()- a2.getWeight()));
		// by 
		list.sort(java.util.Comparator.comparing(Apple::getWeight));
		
		Function<String, Integer> stringToInteger = Integer::parseInt;
		BiPredicate<List<String>, String> contains = List::contains;
		
		Map<String, Function<Integer, Fruit>> map = new HashMap();
		map.put("apple", Apple::new);
		System.out.println(map.size());
		System.out.println(map.get("apple").apply(80));
		
		Function<Integer, Fruit> fun = Apple::new;
		Apple apple = (Apple) fun.apply(50);
		System.out.println(apple);
		
		BiFunction<String, Integer, Apple> biFun = Apple::new;
		Apple newApple = biFun.apply("green", 56);
		System.out.println(newApple);
		
		list.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Comparator.comparing(Apple::getColor)));
		
	}
	
	public static void process(Runnable r){
		r.run();
	}

}

interface Fruit {
	
}

class Apple implements Fruit {
	private String color;
	private int weight;
	
	private Apple(){
		
	}
	
	public Apple(int weight){
		this.weight = weight;
		this.color = "Red";
	}
	
	public Apple(String color, int weight){
		this.weight = weight;
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	
}
