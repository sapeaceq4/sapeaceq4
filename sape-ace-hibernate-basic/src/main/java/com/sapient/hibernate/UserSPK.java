package com.sapient.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HIBERNATE_04_02_01_USER")
public class UserSPK {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
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

	@OneToOne(
			fetch = FetchType.LAZY,
			optional = true,
			mappedBy = "user",
			cascade = CascadeType.ALL
			)
	private AddressSPK shippingAddress = null;
}
