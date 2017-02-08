package com.multithread;

public class Product {

	private Integer totalQuantity;
	
	public boolean placeOrder(Integer orderQuantity){
		if(totalQuantity>=orderQuantity){
			totalQuantity = totalQuantity-orderQuantity;
		}else{
			throw new RuntimeException("Product not found!");
		}
		return true;
	}
}
