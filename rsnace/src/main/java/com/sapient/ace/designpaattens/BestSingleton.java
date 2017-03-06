package com.sapient.ace.designpaattens;

/**
 * Created by Ravdeep Singh on 3/3/2017.
 */
public class BestSingleton {

    private BestSingleton() {
        System.out.println();
    }

    static {
        System.out.println("BestSingleton.enclosing_method()");
    }

    public static void main (String[] args) {
        System.out.println("..");

    }

    private static class BestSingletonHelper {
        static {
            System.out.println("BestSingleton.BestSingletonHelper.enclosing_method()");
        }
        private static final BestSingleton INSTANCE = new BestSingleton();
    }

    public static BestSingleton getInstance() {
        return BestSingletonHelper.INSTANCE;
    }

}

