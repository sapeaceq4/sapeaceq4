package com.sapient.algo;

import java.util.*;
import java.io.*;

/**
 * @author kupad3
 * TODO Need to refactor the code.
 */
public class LargeFileSorter {


	/**************************************************************************
	 *  we divide the file into small blocks. If the blocks
	 *  are too small, we shall create too many temporary files. 
	 *  If they are too big, we shall be using too much memory. 
	 * @param ramSize 
	 *************************************************************************/
	public static long estimateBestSizeOfBlocks(File filetobesorted, int ramSize) {
		long sizeoffile = filetobesorted.length();

		long blocksize = sizeoffile / ramSize ;
		
		System.out.println( blocksize/(1024*1024) + "chunks of size: " + ramSize + " MB");

		return blocksize;
	}

	/**************************************************************************
	 * This will simply load the file by blocks of x rows, then
	 * sort them in-memory, and write the result to a bunch of 
	 * temporary files that have to be merged later.
	 * 
	 * @param file some flat  file
	 * @param ramSize 
	 * @return a list of temporary flat files
	 *************************************************************************/ 

	public static List<File> sortInBatch(File file, Comparator<String> cmp, int ramSize) throws IOException {
		List<File> files = new ArrayList<File>();
		BufferedReader fbr = new BufferedReader(new FileReader(file));
		long blocksize = estimateBestSizeOfBlocks(file, ramSize);// in bytes
		
		try{
			List<String> tmplist =  new ArrayList<String>();
			String line = "";
			try {
				while(line != null) {
					long currentblocksize = 0;
					while((currentblocksize < blocksize) 
							&&(   (line = fbr.readLine()) != null) ){ 
						tmplist.add(line);
						currentblocksize += line.length(); 
					}
					files.add(sortAndSave(tmplist,cmp));
					tmplist.clear();
				}
			} catch(EOFException oef) {
				if(tmplist.size()>0) {
					files.add(sortAndSave(tmplist,cmp));
					tmplist.clear();
				}
			}
		} finally {
			fbr.close();
		}
		return files;
	}


	public static File sortAndSave(List<String> tmplist, Comparator<String> cmp) throws IOException  {
		Collections.sort(tmplist,cmp);
		File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
		newtmpfile.deleteOnExit();
		BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
		try {
			for(String r : tmplist) {
				fbw.write(r);
				fbw.newLine();
			}
		} finally {
			fbw.close();
		}
		return newtmpfile;
	}

	/**
	 * Method to merge all temporary sorted files.
	 * @param temp sorted files
	 * @param outputfile
	 * @param cmparator
	 * @throws IOException
	 */
	public static int mergeSortedFiles(List<File> files, File outputfile, final Comparator<String> cmp) throws IOException {
		PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<BinaryFileBuffer>(11, 
				new Comparator<BinaryFileBuffer>() {
			public int compare(BinaryFileBuffer i, BinaryFileBuffer j) {
				return cmp.compare(i.peek(), j.peek());
			}
		}
				);
		for (File f : files) {
			BinaryFileBuffer bfb = new BinaryFileBuffer(f);
			pq.add(bfb);
		}
		BufferedWriter fbw = new BufferedWriter(new FileWriter(outputfile));
		int rowcounter = 0;
		try {
			while(pq.size()>0) {
				BinaryFileBuffer bfb = pq.poll();
				String r = bfb.pop();
				fbw.write(r);
				fbw.newLine();
				++rowcounter;
				if(bfb.empty()) {
					bfb.fbr.close();
					bfb.originalfile.delete();
				} else {
					pq.add(bfb); 
				}
			}
		} finally { 
			fbw.close();
			for(BinaryFileBuffer bfb : pq ) bfb.close();
		}
		return rowcounter;
	}

	public static void main(String[] args) throws IOException {
		if(args.length<2) {
			System.out.println("please provide input and output file names");
			return;
		}
		String inputfile = args[0];
		String outputfile = args[1];
		
		int ramSize = 20; // In MB

		File inputFile = new File(inputfile);
		System.out.println("Input File:" + inputFile.getName() + "\nSize: " + inputFile.length()/(1024*1024) + " MB");

		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String r1, String r2) {
				return r1.compareTo(r2);
			}
		};

		List<File> l = sortInBatch(inputFile, comparator, ramSize) ;
		mergeSortedFiles(l, new File(outputfile), comparator);
		System.out.println("File is sorted.");
	}
}


class BinaryFileBuffer  {
	public static int BUFFERSIZE = 2048;
	public BufferedReader fbr;
	public File originalfile;
	private String cache;
	private boolean empty;

	public BinaryFileBuffer(File f) throws IOException {
		originalfile = f;
		fbr = new BufferedReader(new FileReader(f), BUFFERSIZE);
		reload();
	}

	public boolean empty() {
		return empty;
	}

	private void reload() throws IOException {
		try {
			if((this.cache = fbr.readLine()) == null){
				empty = true;
				cache = null;
			}
			else{
				empty = false;
			}
		} catch(EOFException oef) {
			empty = true;
			cache = null;
		}
	}

	public void close() throws IOException {
		fbr.close();
	}


	public String peek() {
		if(empty()) return null;
		return cache.toString();
	}
	public String pop() throws IOException {
		String answer = peek();
		reload();
		return answer;
	}



}