package com.sapient.ace.lambda;

import jdk.internal.org.objectweb.asm.Opcodes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by rsi164 on 3/7/2017.
 */
public class LambdaClient {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> System.out.println(" Hello"));
        thread.start();

        BiFunction<String, String, Integer> comp
                = (first, second) -> Integer.compare(first.length(), second.length());

        System.out.println(comp.apply("hdhd", "jsdjsjdsdk"));

        LambdaClient lambda = new LambdaClient();
        lambda.check();


    }

    private void check() {

        System.out.println();

        List<Integer> values = Arrays.asList(1, 2,3, 4, 5, 6, 7, 8, 3, 9, 10, 11, 12, 13);
        //method reference
        values.forEach(System.out::println);

        System.out.println(values.stream().reduce(0, (total, e) -> Integer.sum(total, e)));

        //streams
        System.out.println(values.stream().filter(e -> e > 5).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst().get());

    }
}
