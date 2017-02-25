package com.sapient.rsn.ace.spring.core.bean;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class Teacher {

    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
