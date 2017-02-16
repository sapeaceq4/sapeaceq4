package org.om.aec.spring;

public class Address
{
	private String city;
	private String state;
	private String country;

	public Address(String country, String state,  String city)
	{
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	
}
