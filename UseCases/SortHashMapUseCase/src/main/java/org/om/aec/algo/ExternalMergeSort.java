package org.om.aec.algo;

import java.io.File;
import java.io.IOException;


public class ExternalMergeSort
{

    public static void main(String[] args) throws IOException
    {
        
        File inputFile = new File("./data/bigFile.txt");
        FileSorter sorter = new FileSorter();
        sorter.sort(inputFile);

    }


}