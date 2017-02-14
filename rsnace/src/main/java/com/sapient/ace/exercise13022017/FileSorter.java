package com.sapient.ace.exercise13022017;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ravdeep Singh on 2/13/2017.
 */

public class FileSorter {
//    private static final int blockSize = 1000;

    public File sort(File inputFile) throws IOException {
        File outPutFile = null;
        long sizeOfInputfileInKB = inputFile.length() / (1024);
//        int sizeOfChunk = (int) (sizeOfInputfileInKB / 10) + 1;
//        int sizeOfChunk = (int) (sizeOfInputfileInKB / 10) ;
        System.out.println("sizeOfInputfileInKB " + sizeOfInputfileInKB + "sizeOfChunk: " + 102400);
        List<File> tempFiles = readInputFileAndCreateSortedChunk(inputFile, 102400);
        System.out.println(tempFiles.size());
        outPutFile = nWayMerge(tempFiles);
        return outPutFile;
    }

    private File nWayMerge(List<File> tempFiles) throws IOException {
        int numberOfTempFiles = tempFiles.size();
        System.out.println();
        File outputFile = new File(tempFiles.get(1).getParent() + "/output.txt");
        BufferedReader br[] = new BufferedReader[numberOfTempFiles];
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
        PriorityQueue<String> mergerQ = new PriorityQueue<>();

        for (int i = 0; i < numberOfTempFiles; i++) {
            br[i] = new BufferedReader(new FileReader(tempFiles.get(i)));
        }
        String[] bufferStringArray = new String[numberOfTempFiles];

        for (int i = 0; i < numberOfTempFiles; i++) {
            BufferedReader reader = br[i];
            String qString = reader.readLine().trim();
            bufferStringArray[i] = qString;
            mergerQ.add(qString);
        }

        while (true) {
            boolean complete = false;
            String headString;

            headString = mergerQ.poll();
            outFile.write(headString);
            outFile.write("\n");

            int index = findHeadPointer(bufferStringArray, headString);

            String line;
            if ((line = br[index].readLine()) != null) {
                mergerQ.add(line.trim());
                bufferStringArray[index] = line.trim();
            }
            for (int i = 0; i < numberOfTempFiles; i++) {
                if (br[i].readLine() == null) {
                    complete = true;
                }
            }

            if (complete)
                break;

        }
        return outputFile;
    }

    private int findHeadPointer(String[] bufferStringArray, String headString) {

        for (int i = 0; i < bufferStringArray.length; i++) {
            if (bufferStringArray[i].equalsIgnoreCase(headString))
                return i;

        }
        return -1;
    }


    public static File sortandcreatetemp(List<String> tmplist) throws IOException {
        Collections.sort(tmplist);
        File newtmpfile = File.createTempFile("temp", ".txt");
//        newtmpfile.deleteOnExit();
        BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
        try {
            for (String r : tmplist) {
                fbw.write(r);
                fbw.newLine();
            }
        } finally {
            fbw.close();
        }
        return newtmpfile;
    }

    private List<File> readInputFileAndCreateSortedChunk(File inputFile, int size) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        long blocksize = size;
        try {
            List<String> tmplist = new ArrayList<>();
            String line = "";
            try {
                long currentblocksize = 0;
                while ((currentblocksize < blocksize) && ((line = bufferedReader.readLine()) != null)) {
                    tmplist.add(line);
                    currentblocksize += line.length();
                    if (currentblocksize >= blocksize) {
                        files.add(sortandcreatetemp(tmplist));
                        tmplist.clear();
                        currentblocksize = 0;
                    }
                }
            } catch (EOFException oef) {
                if (tmplist.size() > 0) {
                    files.add(sortandcreatetemp(tmplist));
                    tmplist.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            bufferedReader.close();
        }
        return files;

    }
}
