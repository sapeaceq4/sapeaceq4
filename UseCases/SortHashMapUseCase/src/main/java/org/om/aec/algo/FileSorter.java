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

    public File sort(File inputFile) throws IOException 
    {

        File outPutFile = null;

        long sizeOfInputfileInKB = inputFile.length() / (1024);
        long sizeOfChunk = (int) (sizeOfInputfileInKB / 10) + 1;

        System.out.println("TotalSize="+inputFile.length() +" ,sizeOfInputfileInKB="+ sizeOfInputfileInKB 
        		+ " ,sizeOfChunk="+ sizeOfChunk 
        		+ " , sizeOfInputfileInKB * sizeOfChunk="+ sizeOfInputfileInKB * sizeOfChunk);
        
        List<File> tempFiles = readInputFileAndCreateSortedChunk(inputFile, 102400);

        outPutFile = nWayMerge(tempFiles, inputFile);       
        
        return outPutFile;
    }

    private File nWayMerge(List<File> tempFiles, File inputFile) throws IOException 
    {
        int numberOfTempFiles= tempFiles.size();
        File outputFile = new File(inputFile.getParent()+"/output.txt");
        BufferedReader br[] = new BufferedReader[numberOfTempFiles];
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outputFile));
        for (int i = 0; i <numberOfTempFiles ; i++) 
        {
            br[i] = new BufferedReader(new FileReader(tempFiles.get(i)));
        }
        
        int blocksize = 10240;
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

    private List<File> readInputFileAndCreateSortedChunk(File inputFile, long sizeOfChunk) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        long blocksize = sizeOfChunk;
        List<String> tmplist = new ArrayList<>();
        long currentblocksize = 0;
        try 
        {
            String line = "";
            try 
            {
                while (((line = bufferedReader.readLine()) != null))
                {
                	tmplist.add(line);
                	currentblocksize += line.length();

                	if(currentblocksize >= blocksize)
                	{
                		System.out.println("Written Size="+ currentblocksize);
                		files.add(sortandcreatetemp(tmplist));
                		tmplist.clear();
                		currentblocksize = 0;
                	}
                }
            } 
            catch (EOFException oef) 
            {
            	oef.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        finally 
        {
            if (tmplist.size() > 0)
            {
            	System.out.println("Finally Written Size="+ currentblocksize);
                files.add(sortandcreatetemp(tmplist));
                tmplist.clear();
            }
            bufferedReader.close();
        }
        return files;

    }
}