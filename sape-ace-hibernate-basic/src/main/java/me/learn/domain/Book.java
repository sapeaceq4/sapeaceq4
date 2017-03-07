/*package me.learn.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	String name;
	
	@ElementCollection(targetClass = java.lang.String.class)
	@CollectionTable(name = "HIBERNATE_03_01_ITEM_IMAGE",
			joinColumns = @JoinColumn(name = "ITEM_ID"))
	@Column(name = "FILENAME", nullable = false)
	Set<String> authors = new HashSet<String>();
}
*/