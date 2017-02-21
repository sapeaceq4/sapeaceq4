package com.sap.ace.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
@Entity
@Table(name = "TBL_RATING")
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_seq")
    @SequenceGenerator(name = "rating_id_seq", sequenceName = "RATING_ID_SEQ", allocationSize = 100)
    private Long id;
    private float rating;
    private long userId;

    private long productId;


    public Rating() {
    }

    public Rating(Long id, float rating, long userId, long productId) {
        this.id = id;
        this.rating = rating;
        this.userId = userId;
        this.productId = productId;
    }

    /*

    public Rating(float rating, long userId, long productId) {
        this.rating = rating;
        this.userId = userId;
        this.productId = productId;
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
