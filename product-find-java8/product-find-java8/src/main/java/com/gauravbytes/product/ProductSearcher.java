package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ProductSearcher {
	private ProductCatalog catalog;

	public ProductSearcher(ProductCatalog catalog) {
		this.catalog = catalog;
	}

	public List<Product> byID(String pid) {
		return catalog.stream()
				.filter(matchedPid -> pid.equals(matchedPid.getID()))
				.collect(Collectors.toList());
	}

	public List<Product> byColor(Color productColorToMatch) {
		
		return catalog.stream()
				.filter(matchedPid -> productColorToMatch.equals(matchedPid.getColor()))
				.collect(Collectors.toList());

	}

	public List<Product> byPrice(double productPriceLimit) {
		
		
		return catalog.stream()
				.filter(matchedPid -> productPriceLimit == matchedPid.getPrice())
				.collect(Collectors.toList());
	}

	public List<Product> bySize(Size sizeToFind) {
		
		
		return catalog.stream()
				.filter(matchedPid -> sizeToFind == matchedPid.getSize())
				.collect(Collectors.toList());
	}

	public List<Product> belowPrice(double price) {
	
		return catalog.stream()
				.filter(product -> product.getPrice() < price)
				.collect(Collectors.toList());
		
	}

	public List<Product> byColorAndBelowPrice(Color color, double price) {
		
		return catalog.stream()
				.filter(product -> product.getPrice() < price && product.getColor() == color)
				.collect(Collectors.toList());
	}

	public List<Product> byColorSizeAndBelowPrice(Color color, Size size,
			double price) {
		
		return catalog.stream()
				.filter(product -> product.getColor() == color && product.getSize() == size
						&& product.getPrice() < price)
				.collect(Collectors.toList());
		
		
	}

	public List<Product> byColorAndAbovePrice(Color color, double price) {
		
		return catalog.stream()
				.filter(product ->product.getColor() == color && product.getPrice() > price)
				.collect(Collectors.toList());
	}

	public List<Product> belowPriceAndNotColor(double price, Color color) {
	
		
		return catalog.stream()
				.filter(product -> product.getPrice() < price && product.getColor() != color)
				.collect(Collectors.toList());
	}
}
