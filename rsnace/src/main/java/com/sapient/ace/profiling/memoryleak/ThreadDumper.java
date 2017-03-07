package com.sapient.ace.profiling.memoryleak;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by Ravdeep Singh on 07-03-2017.
 */
public class ThreadDumper {
    public static void main(String[] args) {
        new ThreadDumper().dumpThreadDump();
        for (int i = 0; i <10; i++) {
            Thread t  = new Thread(()-> System.out.println("hello"));
        }
    }

    public void dumpThreadDump() {

        ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();

        for (ThreadInfo ti : threadMxBean.dumpAllThreads(true, true)) {

            System.out.print(ti.toString());

        }

    }
}
