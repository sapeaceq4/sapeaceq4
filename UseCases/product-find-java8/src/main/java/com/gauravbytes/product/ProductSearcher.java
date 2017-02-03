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

	private Stream<Product> getProductStream() {
		Iterator<Product> products = catalog.iterator();
		Iterable<Product> iterable = () -> products;
		return StreamSupport.stream(iterable.spliterator(), false);
	}
	
	public List<Product> byID(String pid) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getID().equals(pid)).collect(Collectors.toList());
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getID().equals(pid))
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> byColor(Color productColorToMatch) {
		List<Product> foundProducts = new ArrayList<Product>();
//		Iterator<Product> products = catalog.iterator();
		foundProducts= getProductStream().filter(p->p.getColor().equals(productColorToMatch)).collect(Collectors.toList());
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getColor().equals(productColorToMatch))
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> byPrice(double productPriceLimit) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getPrice()==(productPriceLimit)).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getPrice() == productPriceLimit) 
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> bySize(Size sizeToFind) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getSize()==(sizeToFind)).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getSize() == sizeToFind) 
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> belowPrice(double price) {
		
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getPrice()<price).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getPrice() < price) 
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> byColorAndBelowPrice(Color color, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getColor()==color).filter(p->p.getPrice()<price).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getPrice() < price && product.getColor() == color) 
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> byColorSizeAndBelowPrice(Color color, Size size, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getColor()==color && p.getPrice()<price).filter(p->p.getSize()==size).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getColor() == color && 
//				product.getSize() == size &&
//				product.getPrice() < price)
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> byColorAndAbovePrice(Color color, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getColor()==color && p.getPrice()>price).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getColor() == color && 
//				product.getPrice() > price)
//				foundProducts.add(product);
//		}
		return foundProducts;
	}

	public List<Product> belowPriceAndNotColor(double price, Color color) {
		List<Product> foundProducts = new ArrayList<Product>();
		foundProducts= getProductStream().filter(p->p.getColor()!=color && p.getPrice()<price).collect(Collectors.toList());
//		Iterator<Product> products = catalog.iterator();
//		Product product;
//		while (products.hasNext()) {
//			product = products.next();
//			if (product.getPrice() < price && product.getColor() != color)
//				foundProducts.add(product);
//		}
		return foundProducts;
	}
}
