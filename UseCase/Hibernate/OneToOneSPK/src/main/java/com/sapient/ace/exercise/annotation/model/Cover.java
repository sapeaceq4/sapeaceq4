package com.sapient.ace.exercise.annotation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Cover")
public class Cover {
	
	@Id
	@GeneratedValue(generator = "customGenerator")
	@GenericGenerator(name = "customGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "book"))
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Book book = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
