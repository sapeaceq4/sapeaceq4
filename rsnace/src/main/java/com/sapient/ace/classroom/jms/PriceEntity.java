package com.sapient.ace.classroom.jms;

import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class PriceEntity implements Serializable {
    private static final long serialVersionUID =1L;
    String name;
    String id;
    double price;

    public PriceEntity(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String
    toString() {
        return "PriceEntity{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
