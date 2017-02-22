package com.sapient.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Product")
public class Product implements Serializable{

 private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 int id;
 
 @Column
 String name;
 
 @Column
 int size;
 
 @Column
 String color;
 
 @Column
 double avgrating;
 
 public Product() {
	 
 }
 
 public Product(int id, String name, int size, String color) {
	 this.id = id;
	 this.name = name;
	 this.size = size;
	 this.color = color;
 }
 

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public double getAvgrating() {
	return avgrating;
}

public void setAvgrating(double rating) {
	this.avgrating = rating;
}

}