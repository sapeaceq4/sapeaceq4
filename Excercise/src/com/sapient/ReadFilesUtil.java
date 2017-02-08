package com.sapient;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public class ReadFilesUtil {

	public static void listFilesAndFilesSubDirectories(String directoryName) throws IOException {
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
			/*	System.out.println(file.getName());
				System.out.println("File path "+file.getAbsolutePath());
			*/	if("txt".equals(FilenameUtils.getExtension(file.getName()))){
					ReadTxtFile.readTxtFile(file.getAbsolutePath());
				}else if ("xlsx".equals(FilenameUtils.getExtension(file.getName()))){
					ReadXlxFile.read(file.getAbsolutePath());
				}
			} else if (file.isDirectory()) {
				listFilesAndFilesSubDirectories(file.getAbsolutePath());
			}
		}
	}
}
