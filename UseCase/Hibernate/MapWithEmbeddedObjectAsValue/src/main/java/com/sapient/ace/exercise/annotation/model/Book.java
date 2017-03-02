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
	
	@ElementCollection // It determins the type for map. so if we won't use this we will get error saying Could not determine type for: java.util.Map
	@CollectionTable(name="book_author", joinColumns = @JoinColumn(name= "BOOK_ISBN"))
	@Column(name="I_VAL", nullable = false)
	@MapKeyColumn(name = "I_KEY")
	private Map<String, Author> authors = new HashMap<>();

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

	public Map<String, Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Map<String, Author> authors) {
		this.authors = authors;
	}

}
