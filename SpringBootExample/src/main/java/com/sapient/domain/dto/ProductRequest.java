package com.sapient.domain.dto;

public final class ProductRequest 
{
	private int id;
	private String productName;
	private String productColor;
	private int productSize;
	
	public ProductRequest() {
		
	}

	public ProductRequest(int id, String productName, String productColor, int productSize)
	{
		this.id = id;
		this.productName = productName;
		this.productColor = productColor;
		this.productSize = productSize;
	}

	public int getId() {
		return id;
	}
	
	public String getProductName() {
		return productName;
	}

	public int getProductSize() {
		return productSize;
	}

	public String getProductColor() {
		return productColor;
	}
}
