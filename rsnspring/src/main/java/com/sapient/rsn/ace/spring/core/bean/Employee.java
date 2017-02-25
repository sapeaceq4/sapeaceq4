package com.sapient.rsn.ace.spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class Employee {
    private String name;
    private int age;
    private String id;

    @Autowired
    private Department department;



    public Employee(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }
    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", department=" + department +
                '}';
    }
}
