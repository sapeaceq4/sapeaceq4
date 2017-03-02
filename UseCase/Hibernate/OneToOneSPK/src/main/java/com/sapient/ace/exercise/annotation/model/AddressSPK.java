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
@Table(name = "AddressSPK")
public class AddressSPK {
	@Id
	@GeneratedValue(generator = "customGenerator")
	@GenericGenerator(name = "customGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private Long id;
	
	@Column(nullable = false)
	private String address;
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private UserSPK user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserSPK getUser() {
		return user;
	}

	public void setUser(UserSPK user) {
		this.user = user;
	}

}
