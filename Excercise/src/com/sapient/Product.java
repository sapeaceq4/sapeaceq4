package com.sapient;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -2219520296498643662L;

	private String productCode;
	private Double productCost;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

}
