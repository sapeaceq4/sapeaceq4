package com.sapient.rsn.ace.spring.core.bean;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */

@Configuration
public class Item {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
