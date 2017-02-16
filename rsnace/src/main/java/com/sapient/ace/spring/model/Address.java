package com.sapient.ace.spring.model;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Address {
    String stateName;
    String cityName;
    String pinCode;

    public Address(String stateName, String cityName, String pinCode) {
        this.stateName = stateName;
        this.cityName = cityName;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "stateName='" + stateName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
