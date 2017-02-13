package com.cache.com;

import com.cache.dao.Country;
import com.cache.dao.CountryCacheContainer;

/**
 * @author vku150 Vinod Kumar
 */
public class CheckCountryCache {

	public static void main(String[] args) {
		CountryCacheContainer cacheContainer = CountryCacheContainer.getInstance();
		Thread th = new Thread(cacheContainer);
		th.start();
		cacheContainer.addItem(new Country("India"));
		cacheContainer.addItem(new Country("UK"));
		cacheContainer.addItem(new Country("US"));
		cacheContainer.addItem(new Country("AUS"));
		
	}
}
