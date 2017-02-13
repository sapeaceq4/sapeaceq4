package com.sapient.ace.concurrency.blockingqueues;

/**
 * Created by Ravdeep Singh on 2/10/2017.
 */
public class QueueElement {
    private String name;
    @Override
    public String toString() {
        return "QueueElement{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueueElement(String name) {

        this.name = name;
    }
}
