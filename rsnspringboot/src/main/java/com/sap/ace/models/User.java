package com.sap.ace.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
@Entity
@Table(name = "TBL_USER")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "USER_ID_SEQ", allocationSize = 100)
    private long id;
    private String userId;
    private String fName;
    private String lName;
    private String city;


    public User() {
    }

    public User(long id, String userId, String fName, String lName, String city) {
        this.id = id;
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
    }

    public User(String userId, String fName, String lName, String city) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
