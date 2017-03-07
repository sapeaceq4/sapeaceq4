package com.sapient.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "HIBERNATE_04_02_01_ADDRESS")
public class AddressSPK {
	@Id
	@GeneratedValue(generator = "customForeignGenerator")
	@org.hibernate.annotations.GenericGenerator(
			name= "customForeignGenerator",
			strategy="foreign",
			parameters = @org.hibernate.annotations.Parameter(
					name = "property",
					value = "user"
					)
			)
	private Long id;
	
	@Column(nullable = false)
	private String address;
	
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

	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private UserSPK user;
}
