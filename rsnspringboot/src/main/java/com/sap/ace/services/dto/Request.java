package com.sap.ace.services.dto;

import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
public class Request <T> implements Serializable{

    private T values;

    public Request(T values) {
        this.values = values;
    }

    public Request() {
    }

    public T getValues() {
        return values;
    }
}
