package com.sapient.ace.exercise.cache;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class Entity {
    String name;
    String company;
    double salary;

    public Entity(String name, String company, double salary) {
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
