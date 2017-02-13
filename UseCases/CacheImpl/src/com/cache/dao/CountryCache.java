package com.cache.dao;

public class CountryCache {
	private Country country;
	private long liveThreshold;
	private long staleThreshold;
	
	public CountryCache(final long timeOfLoad, final long timeOfStale, final Country country){
		this.country = country;
		this.liveThreshold = liveThreshold;
		this.staleThreshold = staleThreshold;
	}

	public long getLiveThreshold() {
		return liveThreshold;
	}

	public void setLiveThreshold(long liveThreshold) {
		this.liveThreshold = liveThreshold;
	}

	public long getStaleThreshold() {
		return staleThreshold;
	}

	public void setStaleThreshold(long staleThreshold) {
		this.staleThreshold = staleThreshold;
	}

	public Country getCountry() {
		return country;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Country otherObject = (Country) obj;
		return this.country.getCountryName().equals(otherObject.getCountryName());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.country.getCountryName().hashCode();
	}
	
	
}
