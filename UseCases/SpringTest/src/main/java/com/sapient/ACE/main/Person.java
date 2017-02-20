package com.sapient.ACE.main;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello world!
 *
 */
public class Person 
{
	private int id;
	private String name;
	@Autowired
	private Address address;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	private static Address aaaa() {
		System.out.println("ZZZ");
		return new Address();
		
	}
    @Override
    public String toString() {
    	return "name--"+name+"address---"+address.getCity();
    }
}
