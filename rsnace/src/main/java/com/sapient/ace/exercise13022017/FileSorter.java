package com.sapient.ace.exercise13022017;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ravdeep Singh on 2/13/2017.
 */
public class FileSorter {
    private static final int blockSize = 1000;

    public File sort(File inputFile) throws IOException {

        File outPutFile = null;

        long sizeOfInputfileInMB = inputFile.length() / 1000 * 1000;
        int numberOfChunks = (int) (sizeOfInputfileInMB / 100) + 1;

        List<File> tempFiles = readInputFileAndCreateSortedChunk(inputFile);

        outPutFile = nWayMerge(tempFiles);       
        
        return outPutFile;
    }

    private File nWayMerge(List<File> tempFiles) throws IOException {
        int numberOfTempFiles= tempFiles.size();
        File outputFile = new File(tempFiles.get(1).getParent()+"/output.txt");
        BufferedReader br[] = new BufferedReader[numberOfTempFiles];
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
        for (int i = 0; i <numberOfTempFiles ; i++) {
            br[i] = new BufferedReader(new FileReader(tempFiles.get(i)));
        }
        //Read nad merge From files

        return outputFile;
    }


    public static File sortandcreatetemp(List<String> tmplist) throws IOException {
        Collections.sort(tmplist);
        File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
        newtmpfile.deleteOnExit();
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

    private List<File> readInputFileAndCreateSortedChunk(File inputFile) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        long blocksize = blockSize;
        try {
            List<String> tmplist = new ArrayList<>();
            String line = "";
            try {
                long currentblocksize = 0;
                while ((currentblocksize < blocksize) && ((line = bufferedReader.readLine()) != null)){
                    while (line != null) {
                        tmplist.add(line);
                        currentblocksize += line.length();
                    }
                    files.add(sortandcreatetemp(tmplist));
                    tmplist.clear();
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
