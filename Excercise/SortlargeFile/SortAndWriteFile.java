package com.main.java.sapient.sortfile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SortAndWriteFile {

	public static void main(String[] args) {
		
		try {
			List<String> fileData =  ReadWriteFile.readFile();
			System.out.println("File Data "+fileData);
			Collections.sort(fileData);
			System.out.println("Sorted File Data "+fileData);
			String returnValue = ReadWriteFile.writeFile(fileData);
			System.out.println("Result: ["+returnValue+"]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
