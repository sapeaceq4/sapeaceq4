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
        Scanner scanners[] = new Scanner[numberOfTempFiles];
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
        PriorityQueue<String> mergerQ = new PriorityQueue<String>();

        for (int i = 0; i < numberOfTempFiles; i++) {
            scanners[i] = new Scanner(tempFiles.get(i));
        }
        String[] bufferStringArray = new String[numberOfTempFiles];

        for (int i = 0; i < numberOfTempFiles; i++) {
            Scanner scanner = scanners[i];
            String qString = scanner.nextLine().trim();
            bufferStringArray[i] = qString;
            mergerQ.add(qString);
        }
        boolean complete = false;
        int lineCount = 0;

        while (true) {
            String headString = mergerQ.poll();
//            System.out.println("linecount " + lineCount++ + " head string " + headString + " Q size " + mergerQ.size());
            if (headString != null) {
                outFile.write(headString);
                outFile.newLine();
            }
            complete = checkIfAllNull(scanners);

            System.out.println("complete status " + complete + "q size" + mergerQ.size());

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

            int index = findHeadPointer(bufferStringArray, headString);

            if (scanners[index].hasNextLine()) {
                String line = scanners[index].nextLine().trim();
                mergerQ.add(line);
                bufferStringArray[index] = line;
            }
        }
        return outputFile;
    }

    private boolean checkIfAllNull(Scanner[] scan) throws IOException {
        boolean flag = true;
        int i = 0;
        for (; i < scan.length; i++) {
            System.out.println("buffer check " + i + " " + scan[i].hasNextLine());
            if (scan[i].hasNextLine()) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    private int findHeadPointer(String[] bufferStringArray, String headString) {

        for (int i = 0; i < bufferStringArray.length; i++) {
            if (bufferStringArray[i].equalsIgnoreCase(headString)) {
                System.out.println("filepointer is " + i);
                return i;
            }
        }
        return -1;
    }


    public static File sortandcreatetemp(List<String> tmplist) throws IOException {
        Collections.sort(tmplist);
        File newtmpfile = File.createTempFile("filesorter", ".txt");
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
