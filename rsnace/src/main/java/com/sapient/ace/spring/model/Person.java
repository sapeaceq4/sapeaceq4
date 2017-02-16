package com.sapient.ace.spring.model;

import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Person  {


    String name;
    String age;

    Address adress;
    public Person(String name, String age, Address adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }


}
