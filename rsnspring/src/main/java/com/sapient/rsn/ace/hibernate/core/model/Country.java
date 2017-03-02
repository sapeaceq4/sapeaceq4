package com.sapient.rsn.ace.hibernate.core.model;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Ravdeep Singh on 01-03-2017.
 */

@Entity
@Table(name = "Country")
@FetchProfile(name = "country_states", fetchOverrides = {
        @FetchProfile.FetchOverride(entity = Country.class, association = "states", mode = FetchMode.JOIN)
})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="countryId")
    private Set<State> states;

    public Country(int id,String name,Set<State> states){
        this.id=id;
        this.name=name;
        this.states=states;
    }
    public Country(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<State> getStates() {
        return states;
    }
    public void setStates(Set<State> states) {
        this.states = states;
    }
}
