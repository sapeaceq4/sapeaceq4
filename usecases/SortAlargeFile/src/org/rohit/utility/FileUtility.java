package org.rohit.utility;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

	public static List<File> splitFile(File file, int sizeOfFileInMB) {
		int counter = 1;
		List<File> files = new ArrayList<File>();
		int sizeOfChunk = 1024 * 1024 * sizeOfFileInMB;
		String eof = System.lineSeparator();
		try
		{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String name = file.getName();
		String line = br.readLine();
		while (line != null) {
			File newFile = new File(file.getParent(), name + "."
					+ String.format("%03d", counter++));
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					newFile));
			int fileSize = 0;
			while (line != null) {
				byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
				if (fileSize + bytes.length > sizeOfChunk)
					break;
				out.write(bytes);
				fileSize += bytes.length;
				line = br.readLine();
			}

			files.add(newFile);

		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return files;

	}
}