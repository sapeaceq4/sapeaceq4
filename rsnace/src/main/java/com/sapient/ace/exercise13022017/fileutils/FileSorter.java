package com.sapient.ace.exercise13022017.fileutils;

import java.io.*;
import java.util.*;

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
        List<File> tempFiles = readInputFileAndCreateSortedChunk(inputFile, /*102400*/1024 * 10);
        System.out.println(tempFiles.size());
        outPutFile = nWayMerge(tempFiles, inputFile);

        return outPutFile;
    }

    //N way merge using priorityQ
    private File nWayMerge(List<File> tempFiles, File inputFile) throws IOException {
        int numberOfTempFiles = tempFiles.size();
        System.out.println();
        File outputFile = new File(inputFile.getParent() + "/output.txt");
        BufferedReader br[] = new BufferedReader[numberOfTempFiles];
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
        PriorityQueue<String> mergerQ = new PriorityQueue<String>();

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
        boolean complete = false;
        int lineCount = 0;
        while (true) {
            String headString;
            headString = mergerQ.poll();
            System.out.println("linecount " + lineCount++ + " head string " + headString + " Q size " + mergerQ.size());

            complete = checkIfAllNull(br);

            if (complete) {
                System.out.println("-------------Completion------------");
                System.out.println("Qsize :" + mergerQ.size());
                System.out.println(mergerQ.size());
                System.out.println("BufferString Array " + Arrays.toString(bufferStringArray));

                while ((headString = mergerQ.poll()) != null) {
                    outFile.write(headString);
                    System.out.println("Qsize " + mergerQ.size());
                }
                break;
            }
//            if (headString != null) {
            outFile.write(headString);
            outFile.newLine();
//            }
            int index = findHeadPointer(bufferStringArray, headString);

            String line;
            if ((line = br[index].readLine()) != null) {
                mergerQ.add(line.trim());
                bufferStringArray[index] = line.trim();
            }


        }
        return outputFile;
    }

    private boolean checkIfAllNull(BufferedReader[] br) throws IOException {
        int bufferSize = 1024;
        boolean flag = false;
        int i = 0;
        for (; i < br.length; i++) {
            br[i].mark(bufferSize);
            char[] buf = new char[bufferSize];
            if (br[i].read(buf)>=1) {
//            if (br[i].ready()) {
                br[i].reset();
                flag = true;
                break;
            }

        }
        return flag;
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
        List<String> tmplist = new ArrayList<>();
        long currentblocksize = 0;
        try {
            String line = "";
            try {
                while ((currentblocksize < blocksize) && ((line = bufferedReader.readLine()) != null)) {
                    tmplist.add(line);
                    currentblocksize += line.length();
                    if (currentblocksize >= blocksize) {
//                        System.out.println("bytes written " + currentblocksize);
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
            if (tmplist.size() > 0) {
                files.add(sortandcreatetemp(tmplist));
                tmplist.clear();
            }
            bufferedReader.close();
        }
        return files;

    }
}
