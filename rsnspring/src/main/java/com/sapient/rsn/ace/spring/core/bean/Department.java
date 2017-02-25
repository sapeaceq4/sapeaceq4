package com.sapient.rsn.ace.spring.core.bean;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class Department {
    private String name;
    private int id;


    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
