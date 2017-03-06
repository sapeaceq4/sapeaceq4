package com.sapient.ace.usecases;

/**
 * Created by Ravdeep Singh on 3/3/2017.
 */
public class SatusClient {
    public static void main(String[] args) {
        Status status1 = Status.ACTIVE;
        Status status2 = Status.INACTIVE;
        Status status3 = Status.UNKNOWN;

        Status inpStatus = status3;

        inpStatus.doSomething();
    }
}
