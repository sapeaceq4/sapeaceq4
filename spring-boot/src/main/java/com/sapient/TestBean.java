package com.sapient;

import org.springframework.stereotype.Controller;

@Controller("Bean1")
public class TestBean {
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id+", "+name;
	}

}
