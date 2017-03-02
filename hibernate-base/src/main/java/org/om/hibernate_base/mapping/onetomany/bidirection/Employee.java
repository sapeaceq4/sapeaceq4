package org.om.hibernate_base.mapping.onetomany.bidirection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_EMPLOYEE")
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	private Company company;
	
	public Employee()
	{
		
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Company getCompany()
	{
		return company;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
