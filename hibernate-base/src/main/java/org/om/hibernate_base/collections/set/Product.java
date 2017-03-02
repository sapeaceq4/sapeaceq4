package org.om.hibernate_base.collections.set;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_PRODUCT")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ElementCollection
	private Set<String> images = new HashSet<>();
	
	public Product(String name) 
	{
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getImages() {
		return images;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", images=" + images
				+ "]";
	}
}
