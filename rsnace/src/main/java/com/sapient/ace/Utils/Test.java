package com.sapient.ace.Utils;

import java.util.*;

import static java.util.Collections.*;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Test {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("g");
        input.add("c");
        input.add("i");
        input.add("q");
        input.add("m");

        System.out.println(input);
        sort(input);
        System.out.println(input);
        input.add("x");
        input.add("b");
        System.out.println(input);
    }
}
