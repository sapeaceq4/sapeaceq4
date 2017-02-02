package com.sapient.ace.java8.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.sapient.ace.java8.assignment.Color;
import com.sapient.ace.java8.assignment.Product;
import com.sapient.ace.java8.assignment.ProductCatalog;
import com.sapient.ace.java8.assignment.ProductSearcher;
import com.sapient.ace.java8.assignment.Size;

public class ProductSelectionTest {
	private ProductSearcher productSearcher;
	private ProductCatalog catalog;

	private Product railTrack = new Product("r187", "Rail Track", Color.RED, 3.45d,
	    Size.MEDIUM);

	private Product barbieDoll = new Product("b187", "Barbie Doll", Color.PINK, 7.15d,
	    Size.SMALL);

	private Product monsterTruck = new Product("m187", "Monster Truck", Color.YELLOW, 9.99d,
	    Size.LARGE);

	private Product cricketBat = new Product("b2343", "Cricket Bat", Color.WHITE, 19.25d,
	    Size.NOT_APPLICABLE);

	private Product toyCar = new Product("t187", "Toy Skoda", Color.RED, 125.00d,
	    Size.NOT_APPLICABLE);

	@Before
	public void setUp() {
		productSearcher = new ProductSearcher(createProductCatalog());
	}

	private ProductCatalog createProductCatalog() {
		catalog = new ProductCatalog();
		catalog.add(railTrack);
		catalog.add(barbieDoll);
		catalog.add(monsterTruck);
		catalog.add(cricketBat);
		catalog.add(toyCar);
		return catalog;
	}

	@Test
	public void testFindByID() {
		String pid = "r187";
		Predicate<Product> predicate = p -> p.getID().equals(pid);
		List<Product> foundProducts = productSearcher.byID(predicate);

		assertEquals(1, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));
	}

	@Test
	public void testFindBySize() {
		Predicate<Product> predicate = p -> p.getSize() == Size.MEDIUM;
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(1, foundProducts.size());

		predicate = p -> p.getSize() == Size.NOT_APPLICABLE;
		foundProducts = productSearcher.byID(predicate);
		assertEquals(2, foundProducts.size());
	}

	@Test
	public void testFindByColor() {
		
		Predicate<Product> predicate = p -> p.getColor().equals(Color.RED);
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(2, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));

		assertTrue(foundProducts.contains(toyCar));
	}

	@Test
	public void testFindByPrice() {
		Predicate<Product> predicate = p -> p.getPrice() == 19.25d;
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(1, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() == 19.25d);
		}
	}

	@Test
	public void testFindBelowPrice() {
		Predicate<Product> predicate = p -> p.getPrice() < 10.00f;
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(3, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() < 10.00d);
		}
	}

	@Test
	public void testFindByColorAndBelowPrice() {
		Predicate<Product> predicate = p -> (p.getPrice() < 10.00d) && (p.getColor() == Color.RED);
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(1, foundProducts.size());
		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorSizeAndBelowPrice() {
		Predicate<Product> predicate = p -> (p.getColor() == Color.RED) && (p.getSize() == Size.SMALL) && (p.getPrice() < 10.00d);
		List<Product> foundProducts = productSearcher.byID(predicate);

		assertEquals(0, foundProducts.size());
		predicate = p -> (p.getColor() == Color.RED) && (p.getSize() == Size.MEDIUM) && (p.getPrice() < 10.00d);
		foundProducts = productSearcher.byID(predicate);

		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorAndAbovePrice() {
		Predicate<Product> predicate = p -> (p.getColor() == Color.WHITE) && (p.getPrice() > 25.00d);
		List<Product> foundProducts = productSearcher.byID(predicate);
		
		assertEquals(0, foundProducts.size());

		predicate =p -> (p.getColor() == Color.RED) && (p.getPrice() > 25.00d);
		foundProducts = productSearcher.byID(predicate);
		
		assertEquals(toyCar, foundProducts.get(0));
	}

	@Test
	public void testFindBelowPriceAvoidingAColor() {
		Predicate<Product> predicate = p -> (p.getPrice() < 20.00d) && (p.getColor() != Color.WHITE);
		List<Product> foundProducts = productSearcher.byID(predicate);
		assertEquals(3, foundProducts.size());
		assertTrue(foundProducts.contains(railTrack));
	}
}
