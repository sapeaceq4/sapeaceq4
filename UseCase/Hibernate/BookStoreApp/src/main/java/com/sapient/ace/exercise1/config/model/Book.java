package com.sapient.ace.exercise1.config.model;

import java.util.Date;

import javax.persistence.Id;

public class Book {
	@Id
	private Long isbn;
	private String title;
	private Date pubDate;

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

}
