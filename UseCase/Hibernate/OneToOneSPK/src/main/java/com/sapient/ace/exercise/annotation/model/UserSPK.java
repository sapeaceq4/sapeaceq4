package com.sapient.ace.exercise.annotation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userSPK")
public class UserSPK {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@OneToOne(fetch = FetchType.LAZY, optional = true,  cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private AddressSPK shippingAddress = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressSPK getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressSPK shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
