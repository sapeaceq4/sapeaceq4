package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
	
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
	
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
