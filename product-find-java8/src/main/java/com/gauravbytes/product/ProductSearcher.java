package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
	
	private Iterable<Product> getProductIterable() {
		Iterator<Product> products = catalog.iterator();
		Iterable<Product> iterable = () -> products;
		return iterable;
	}

	public List<Product> byID(String pid) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter(p -> p.getID().equals(pid)).collect(Collectors.toList());
		return foundProducts;
	}  
	
	

	

	public List<Product> byColor(Color productColorToMatch) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter(p -> p.getColor().equals("productColorToMatch")).collect(Collectors.toList());
				
				return foundProducts;
	}

	public List<Product> byPrice(double productPriceLimit) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter(p -> p.getPrice()==(productPriceLimit)).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> bySize(Size sizeToFind) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter(p -> p.getSize().equals(sizeToFind)).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> belowPrice(double price) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter(p -> p.getPrice()<(price)).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColorAndBelowPrice(Color color, double price) {
		Iterable<Product> iterable = getProductIterable();
		List<Product> foundProducts = StreamSupport.stream(iterable.spliterator(), false).filter((p -> p.getPrice() < price) && (p -> p.getColor()== color)).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColorSizeAndBelowPrice(Color color, Size size, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getColor() == color && 
				product.getSize() == size &&
				product.getPrice() < price)
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byColorAndAbovePrice(Color color, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getColor() == color && 
				product.getPrice() > price)
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> belowPriceAndNotColor(double price, Color color) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getPrice() < price && product.getColor() != color)
				foundProducts.add(product);
		}
		
		
		return foundProducts;
	}
}