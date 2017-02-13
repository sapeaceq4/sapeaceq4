package com.main.java.sapient.sortfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
	

	public static List<String> readFile() throws IOException {
		List<String> fileData = new ArrayList<String>();
		/*RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\Files\\filedata.txt", "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		Charset charset = Charset.forName("US-ASCII");
		while (fileChannel.read(byteBuffer) > 0) {
			byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			fileData.add(charset.decode(byteBuffer).toString());
			byteBuffer.flip();
		}
		fileChannel.close();
		randomAccessFile.close();*/

		Charset charSet = Charset.forName("Us-ASCII");
		Path filePath = FileSystems.getDefault().getPath("D:\\Files\\filedata.txt");
		BufferedReader bufReader =  Files.newBufferedReader(filePath,charSet);
		String line = null;
		while((line=bufReader.readLine())!=null){
			//System.out.println(line);
			fileData.add(line);
		}
	
		System.out.println(fileData.size());
		return fileData;
	}

	public static String writeFile(List<String> fileData) {
		try {
			byte[] buffer = "Help I am trapped in a fortune cookie factory\n".getBytes();

			@SuppressWarnings("resource")
			FileChannel rwChannel = new RandomAccessFile("D:\\Files\\newfiledata.txt", "rw").getChannel();
			ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length * fileData.size());
			for (String str : fileData) {
					wrBuf.put(str.getBytes());
					wrBuf.put("\n".getBytes());
			}
			/*for (int i = 0; i < number_of_lines; i++) {
				wrBuf.put(buffer);
			}*/
			rwChannel.close();
			return "File Written Successfully";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "File Written Fail";
		}
		
	}

	public static void main(String[] args) {
		try {
			readFile();
			//writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
