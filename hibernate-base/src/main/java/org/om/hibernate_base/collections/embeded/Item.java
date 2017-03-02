package org.om.hibernate_base.collections.embeded;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
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
	@CollectionTable(name="H_ITEM_IMAGE")
	@Column(name="FILE_NAME")
	@MapKeyColumn(name="IMAGE_KEY")
	private Map<String, Image> images = new HashMap<String, Image>();
	
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

	public Map<String, Image> getImages() {
		return images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", images=" + images
				+ "]";
	}
}
