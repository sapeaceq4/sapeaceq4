package com.sapient.rsn.ace.hibernate.core.models;

import javax.persistence.*;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */

@Entity
@Table(name = "H_TBL_COVER")
public class Cover {
    @Id
    @GeneratedValue(generator = "customForeignGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "customForeignGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(
                    name = "property",
                    value = "book"))
    private int id;

    private String name;


    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Book book;

    @Override
    public String toString() {
        return "Cover{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cover() {
    }

    public Cover(int id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }
}

