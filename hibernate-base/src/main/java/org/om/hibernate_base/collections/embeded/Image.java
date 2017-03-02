package org.om.hibernate_base.collections.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Image 
{
	private String name;
	private String path;
	@Column(name="SIZE_IN_KB")
	private long sizeInKB;
	
	public Image() {
		super();
	}
	
	public Image(String name, String path, long sizeInKB) {
		super();
		this.name = name;
		this.path = path;
		this.sizeInKB = sizeInKB;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public long getSizeInKB() {
		return sizeInKB;
	}

	@Override
	public String toString() {
		return "Image [name=" + name + ", path=" + path + ", sizeInKB="
				+ sizeInKB + "]";
	}
}
