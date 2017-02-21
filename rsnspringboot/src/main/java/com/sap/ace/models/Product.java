package com.sap.ace.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
@Entity
@Table(name = "TBL_PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 100)
    private Integer id;
    private String name;
    private String color;
    private int psize;
    private double avgrating;

    public Product(String name, int psize, String color, float avgrating) {
        this.name = name;
        this.psize = psize;
        this.color = color;
        this.avgrating = avgrating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPsize() {
        return psize;
    }

    public void setPsize(int psize) {
        this.psize = psize;
    }

    public double getAvgrating() {
        return avgrating;
    }

    public void setAvgrating(double avgrating) {
        this.avgrating = avgrating;
    }
}
