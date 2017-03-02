package org.om.hibernate_base.mapping.manytomany.unidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_EMPLOYEE")
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany	
	private List<Company> companies  = new ArrayList<>();
	
	public Employee()
	{
		
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public List<Company> getCompanies() 
	{
		return companies;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", companies="
				+ companies + "]";
	}
}
