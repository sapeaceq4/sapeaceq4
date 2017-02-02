package com.sapient.ace.java8.assignment;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Prem Mishra
 *
 */
public class ProductSearcher {
	private ProductCatalog catalog;

	public ProductSearcher(ProductCatalog catalog) {
		this.catalog = catalog;
	}

	public List<Product> byID(Predicate<Product> predicate) {
		return catalog.getStream().filter(predicate).collect(Collectors.toList());
	}
}
