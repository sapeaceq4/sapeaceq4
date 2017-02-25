package com.sapient.rsn.ace.spring.core.bean;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */

public class Client {
    private String name;
    private String country;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
