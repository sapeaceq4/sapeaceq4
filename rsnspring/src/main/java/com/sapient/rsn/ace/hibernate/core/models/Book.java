package com.sapient.rsn.ace.hibernate.core.models;

import javax.persistence.*;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */

@Entity
@Table(name = "H_TBL_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = true,
            mappedBy = "book")
    private Cover cover;


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }
}
