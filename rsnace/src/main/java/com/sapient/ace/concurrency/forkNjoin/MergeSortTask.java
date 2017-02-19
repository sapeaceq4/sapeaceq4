package com.sapient.ace.concurrency.forkNjoin;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Ravdeep Singh on 19-02-2017.
 */
public class MergeSortTask extends RecursiveAction {
    int[] array;
    int taskSize;

    public MergeSortTask(int[] array, int taskSize) {
        this.array = array;
        this.taskSize = taskSize;
    }

    @Override
    protected void compute() {

        if (array.length <= taskSize) {
        } else {

        }

    }
}
