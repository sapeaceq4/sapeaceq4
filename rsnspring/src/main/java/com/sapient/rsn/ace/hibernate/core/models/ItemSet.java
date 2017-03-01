package com.sapient.rsn.ace.hibernate.core.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */
@Entity
@Table(name = "hibernate_tbl_item")
public class ItemSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_Sequence")
//    @SequenceGenerator(name = "item_id_Sequence", sequenceName = "MY_HIB_SEQ")
    private Long id;

    @Column
    private String name;

    @ElementCollection(targetClass = java.lang.String.class)
    @CollectionTable(name = "hibernate_tbl_item_images", joinColumns = @JoinColumn(name = "ITEM_ID"))
    @Column(name = "FILE_NAME", nullable = true)
    private Set<String> images = new HashSet<String>();

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
