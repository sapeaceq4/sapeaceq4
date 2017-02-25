package com.sapient.ace.iq.macquirie.FinalClases;

/**
 * Created by Ravdeep Singh on 23-02-2017.
 */
public class Employee extends Person {
    private String company;

    public Employee(String name, String company) {
        super(name);
        this.company = company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}