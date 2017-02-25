package com.sapient.rsn.ace.spring.core.bean;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class Address {
    private String streetName;
    private String cityName;
    private String stateName;
    private String country;
    private Integer pincode;

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                '}';
    }

    public String printAddressDetails() {
        return "Address is {" +
                "streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                '}';
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
