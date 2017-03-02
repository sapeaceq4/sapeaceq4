package org.om.hibernate_base.mapping.onetoone.bidirection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_COMPANY")
public class Company 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="company")
	private Employee employee;
	
	public Company(String name)
	{
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", employee="
				+ employee + "]";
	}
	
	
}