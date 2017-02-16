package com.sapient.ace.Utils;

import java.util.PriorityQueue;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("a");
        System.out.printf("size " + priorityQueue.size());

        priorityQueue.add("a");
        System.out.printf("size " + priorityQueue.size());

        priorityQueue.poll();
        System.out.printf("size " + priorityQueue.size());

        priorityQueue.poll();
        System.out.printf("size " + priorityQueue.size());

        priorityQueue.add("a");
        System.out.printf("size " + priorityQueue.size());

    }
}
