package com.sapient.rsn.ace.hibernate.core.mappings.one2oneBi;

import javax.persistence.*;

/**
 * Created by Ravdeep Singh on 02-03-2017.
 */

@Entity
@Table(name = "H_TBL_ADDRESS_121BI")
public class Address {

    private long addressId;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    private Student student;


    @OneToOne()
    @JoinColumn(name = "STUDENT_ID")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Address() {
    }

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Column(name = "ADDRESS_STREET", nullable = false, length = 250)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "ADDRESS_CITY", nullable = false, length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "ADDRESS_STATE", nullable = false, length = 50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "ADDRESS_ZIPCODE", nullable = false, length = 10)
    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}