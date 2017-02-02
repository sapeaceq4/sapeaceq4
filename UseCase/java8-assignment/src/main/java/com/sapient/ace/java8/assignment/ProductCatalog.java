package com.sapient.ace.java8.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
	
/**
 * 
 * @author  Prem Mishra
 *
 */
public class ProductCatalog {
	private List<Product> products = new ArrayList<>();

	public void add(Product product) {
		products.add(product);
	}
	
	public Stream<Product> getStream() {
		return products.stream();
	}
}
