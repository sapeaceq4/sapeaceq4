package com.sapient.ace.cache;

public interface Cacheable {
	
	public boolean isExpired();
	public Object getIdentifier();

}
