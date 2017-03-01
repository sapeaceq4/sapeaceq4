package org.om.hibernate_base.onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TBL_COVER")
public class Cover 
{
	@Id
	@GeneratedValue(generator = "customForeignGenerator")
	@org.hibernate.annotations.GenericGenerator(
			name = "customForeignGenerator",
			strategy = "foreign",
			parameters = @org.hibernate.annotations.Parameter(
					name = "property",
					value = "book"))
	private int id;
	private String name;
	
	@OneToOne(optional= false)
	@PrimaryKeyJoinColumn
	private Book book;
	
	public Cover(String name)
	{
		this.name = name;
	}
	
	public void assignBook(Book book)
	{
		book.setCover(this);
		this.book = book;
	}

	@Override
	public String toString() {
		return "Cover [id=" + id + ", name=" + name + ", book=" + book + "]";
	}
}
