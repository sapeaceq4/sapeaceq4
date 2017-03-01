package org.om.hibernate_base.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_BOOK")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne(fetch= FetchType.LAZY,
			optional= true,
			mappedBy= "book",
			cascade = CascadeType.ALL)
	private Cover cover;
	
	public Book(String name)
	{
		this.name = name;
	}
	
	public void setCover(Cover cover)
	{
		this.cover = cover;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", cover=" + cover + "]";
	}
}
