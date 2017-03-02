package org.om.hibernate_base.collections.bag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_ITEM")
public class Item 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ElementCollection
	private Collection<String> images = new ArrayList<>();
	
	public Item(String name) 
	{
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<String> getImages() {
		return images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", images=" + images
				+ "]";
	}
}
