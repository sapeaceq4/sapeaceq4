package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

	public List<Product> byID(String pid) {
		List<Product> foundProducts = getProductStream().filter(
				p -> p.getID().equals(pid)).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColor(Color productColorToMatch) {
		List<Product> foundProducts = getProductStream().filter(
				p -> p.getColor().equals(productColorToMatch)).collect(
				Collectors.toList());
		return foundProducts;
	}

	public List<Product> byPrice(double productPriceLimit) {
		List<Product> foundProducts = getProductStream().filter(
				p -> p.getPrice() == productPriceLimit).collect(
				Collectors.toList());
		return foundProducts;
	}

	public List<Product> bySize(Size sizeToFind) {
		List<Product> foundProducts = getProductStream().filter(
				p -> p.getSize().equals(sizeToFind)).collect(
				Collectors.toList());
		return foundProducts;
	}

	public List<Product> belowPrice(double price) {
		List<Product> foundProducts = getProductStream().filter(
				p -> p.getPrice() < price).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColorAndBelowPrice(Color color, double price) {
		List<Product> foundProducts = getProductStream()
				.filter(p -> p.getColor().equals(color))
				.filter(p -> p.getPrice() < price).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColorSizeAndBelowPrice(Color color, Size size,
			double price) {
		List<Product> foundProducts = getProductStream()
				.filter(p -> p.getColor().equals(color))
				.filter(p -> p.getSize().equals(size))
				.filter(p -> p.getPrice() < price).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> byColorAndAbovePrice(Color color, double price) {
		List<Product> foundProducts = getProductStream()
				.filter(p -> p.getColor().equals(color))
				.filter(p -> p.getPrice() > price).collect(Collectors.toList());
		return foundProducts;
	}

	public List<Product> belowPriceAndNotColor(double price, Color color) {
		List<Product> foundProducts = getProductStream()
				.filter(p -> p.getPrice() < price)
				.filter(p -> !p.getColor().equals(color))
				.collect(Collectors.toList());
		return foundProducts;
	}

	private Stream<Product> getProductStream() {
		Iterator<Product> products = catalog.iterator();
		Iterable<Product> iterable = () -> products;
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
