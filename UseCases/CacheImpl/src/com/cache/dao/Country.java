package com.cache.dao;

/**
 * Expecting a country will never be null and there will be some value in it.
 * @author vku150
 *
 */
public class Country {
	private String countryName = "default";
	
	public String getCountryName() {
		return countryName;
	}

	public Country(final String countryName){
		if(countryName != null){
			this.countryName = countryName;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Country){
			Country otherObject = (Country) obj;
			return this.countryName.equals(otherObject.countryName);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.countryName.hashCode();
	}
}
