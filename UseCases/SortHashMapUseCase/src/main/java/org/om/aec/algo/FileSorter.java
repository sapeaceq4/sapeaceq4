package org.om.aec.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSorter 
{
    private static final int blockSize = 100;

    public File sort(File inputFile) throws IOException 
    {

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
        for (int i = 0; i <numberOfTempFiles ; i++) 
        {
            br[i] = new BufferedReader(new FileReader(tempFiles.get(i)));
        }
        //Read nad merge From files

        int blocksize = 10;
        for(int i = 0; i <numberOfTempFiles ; i++)
        {
        	List<String> tmplist = new ArrayList<>();
        	for(int j = 0; j <numberOfTempFiles ; j++)
            {
               	try 
                {
                    String line = "";
                    try 
                    {
                        long currentblocksize = 0;
                        while (((line = br[i].readLine()) != null))
                        {
                            if (line != null)
                            {
                                tmplist.add(line);
                                currentblocksize += line.length();
                            }
                            if(currentblocksize >= blocksize)
                            {
                            	break;
                            }
                        }
                    } catch (EOFException oef) {
                      
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } finally {
                    //br[i].close();
                }
            }
        	
        	Collections.sort(tmplist);
        	for(String str: tmplist)
        	{
        		outFile.write(str);
        		outFile.newLine();
        	}
        	tmplist.clear();
 
        }
        outFile.close();
        return outputFile;
    }


    public static File sortandcreatetemp(List<String> tmplist) throws IOException
    {
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
        try 
        {
            List<String> tmplist = new ArrayList<>();
            String line = "";
            try 
            {
                long currentblocksize = 0;
                while (((line = bufferedReader.readLine()) != null))
                {
                    if (line != null)
                    {
                        tmplist.add(line);
                        currentblocksize += line.length();
                    }
                    if(currentblocksize >= blocksize)
                    {
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