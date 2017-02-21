package com.sap.ace.services.vo;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
public class ResponseVO <V>{

    private V reponse;

    public ResponseVO() {
    }

    public ResponseVO(V reponse) {
        this.reponse = reponse;
    }

    public V getReponse() {
        return reponse;
    }
}
