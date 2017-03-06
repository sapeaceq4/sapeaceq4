package com.sapient.ace.usecases;

/**
 * Created by Ravdeep Singh on 3/3/2017.
 */
public enum Status {
    INACTIVE {
        public void doSomething() {
            printInActive();
        }
    },
    ACTIVE {
        public void doSomething() {
            printActive();
        }
    },
    UNKNOWN {
        public void doSomething() {
            printUnknown();
        }
    };

    private static void printInActive() {
        System.out.println("inactive");
    }

    private static void printActive() {
        System.out.println("Active");
    }

    private static void printUnknown() {
        System.out.println("Unknown");
    }

    public abstract void doSomething();
}