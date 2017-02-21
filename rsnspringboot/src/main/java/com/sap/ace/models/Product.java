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
    private Long id;
    private String name;
    private String color;
    private int psize;
    private double avgRating;

    public Product() {
    }


    public Product(Long id, String name, String color, int psize, double avgRating) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.psize = psize;
        this.avgRating = avgRating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", psize=" + psize +
                ", avgRating=" + avgRating +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
