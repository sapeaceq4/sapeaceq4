package com.sapient.rsn.ace.hibernate.core.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */

@Entity
@Table(name = "H_TBL_COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID", nullable = true)
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
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

    public void setEmployee(Employee employee) {
        employees.add(employee);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
