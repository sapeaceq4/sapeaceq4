package com.sapient.rsn.ace.spring.core.bean;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class SampleBean {
    @Override
    public String toString() {
        return "SampleBean{" +
                "data='" + data + '\'' +
                ", i=" + i +
                '}';
    }

    private String data;
    private int i;
    public SampleBean(int i) {
        System.out.println(this.getClass().getCanonicalName() + " int");
        this.i = i;
    }
    public SampleBean(String data) {
        System.out.println(this.getClass().getCanonicalName() + " String");
        this.data = data;
    }


}
