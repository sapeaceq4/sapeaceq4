package org.sapient.rsn.persistence.model.entity;

import javax.persistence.*;

/**
 * Created by rsi164 on 2/8/2017.
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department{

    @Id
    @Column //If name is not supplied hibernate will use field name as column name
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String deptName;

    //default constructor
    public void Department(){
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
