package com.sapient.rsn.ace.hibernate.core.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */

@Entity
@Table(name = "H_TBL_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
