package org.om.aec.jsm;

import java.io.Serializable;

public final class PriceEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private final String id;
	private String name;
	private final double price;
	
	public PriceEntity(String name, String id, double price)
	{
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "PriceEntity [name=" + name + ", id=" + id + ", price=" + price
				+ "]";
	}
}
