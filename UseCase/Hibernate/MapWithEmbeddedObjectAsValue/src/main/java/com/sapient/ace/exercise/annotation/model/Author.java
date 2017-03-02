package com.sapient.ace.exercise.annotation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Author {

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;

	public Author() {
	}

	public Author(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
