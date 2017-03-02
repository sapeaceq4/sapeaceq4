package com.sapient.ace.exercise.annotation.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long isbn;
	private String title;
	private Date pubDate;
	
	@ElementCollection
	@CollectionTable(name="book_image", joinColumns = @JoinColumn(name= "ITEM_ID"))
	@Column(name="I_VAL", nullable = false)
//	@MapKey(name = "I_KEY") // If we will use this, then we will get exception saying Associated class not found: java.lang.String
	@MapKeyColumn(name = "I_KEY")
	private Map<String, String> images = new HashMap<>();

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

}
