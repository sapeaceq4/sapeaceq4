package org.om.aec.utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class FileCreator
{ 
	public static void main(String[] args) throws IOException
	{
		if(args.length <1)
		{
			System.out.printf("Usage - Size in MB");
			System.exit(0);
		}
		
		int sizeInMB = Integer.parseInt(args[0]);
		File file = new File("src/main/resources/input.txt");
		FileWriter fos = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fos);
		while (true) {
			printWriter.write(UUID.randomUUID().toString());
			printWriter.write("\n");
			if (file.length() / (1024 * 1024 * sizeInMB) >= 1)
			{
				break;
			}
		}
		printWriter.flush();
		printWriter.close();

		System.out.println("File created of size " + file.length() / (1024 * 1024) + " MB");
}}