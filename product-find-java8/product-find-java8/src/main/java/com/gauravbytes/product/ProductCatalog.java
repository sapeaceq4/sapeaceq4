package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
	
/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ProductCatalog {
	private List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}


	public void add(Product product) {
		products.add(product);
	}
	
	public Stream<Product> stream() {
		return products.stream();
	}
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
