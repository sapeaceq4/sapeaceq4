package com.sapient;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail {

	private static ProductDetail instance = null;
	
	private List<Product> productDetails = new ArrayList<>();

	private ProductDetail() {
	}

	public static ProductDetail getInstance() {
		if (instance == null) {
			synchronized (ProductDetail.class) {
				if (instance == null) {
					instance = new ProductDetail();
				}
			}
		}
		return instance;
	}

	public List<Product> getProductDetails() {
		return instance.productDetails;
	}

	public void setProductDetails(List<Product> productDetails) {
		instance.productDetails = productDetails;
	}
}
