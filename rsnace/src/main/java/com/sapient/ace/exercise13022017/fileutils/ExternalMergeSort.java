package com.sapient.ace.exercise13022017.fileutils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ravdeep Singh on 2/13/2017. *
 * Assuming file is of size 1 GB
 * Will create 1024/100MB = 11 chunks and sort using general sorting and then read and merge
 */
public class ExternalMergeSort {

    public static void main(String[] args) throws IOException {
        if (args.length<1){
            System.out.println("Usage: file to be sorted");
            System.exit(0);
        }
        File inputFile = new File(args[0]);
        FileSorter sorter = new FileSorter();
        sorter.sort(inputFile);

    }


}