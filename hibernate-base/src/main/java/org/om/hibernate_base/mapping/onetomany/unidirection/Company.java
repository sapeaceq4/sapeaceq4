package org.om.hibernate_base.mapping.onetomany.unidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="H_TBL_COMPANY")
public class Company 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Company_Id")
	private List<Employee> employees = new ArrayList<>();
	
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

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() 
	{
		return "Comany [id=" + id + ", name=" + name + ", employees="
				+ employees + "]";
	}
	
}