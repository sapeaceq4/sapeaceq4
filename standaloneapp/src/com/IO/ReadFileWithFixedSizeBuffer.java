package com.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileWithFixedSizeBuffer {

	public static void main(String[] args) {
		try {
			//fileChannelRead();
			readfile();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void readBigTextFile() throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile("D:\\Files\\file1\\file1.txt", "r");
		FileChannel fChannel = raf.getChannel();
		ByteBuffer byteBuff = ByteBuffer.allocate(1024);
		Charset charset = Charset.forName("US-ASCII");
		while(fChannel.read(byteBuff)>0){
			byteBuff.flip();
			for(int i=0;i<byteBuff.limit();i++){
				System.out.println((char)byteBuff.get());
				byteBuff.rewind();
				System.out.print("string is "+charset.decode(byteBuff).toString());
				if(charset.decode(byteBuff).toString().startsWith("p")){
					System.out.println(true);
				}else{
					System.out.println(false);
				}
			}
			byteBuff.clear();
		}
		fChannel.close();
		raf.close();
	}
	
	public static void fileChannelRead() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\Files\\file1\\file1.txt","rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		Charset charset = Charset.forName("US-ASCII");
		while (fileChannel.read(byteBuffer) > 0) {
			byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			byteBuffer.flip();
		}
		fileChannel.close();
		randomAccessFile.close();
	}
	private static void readfile() throws IOException{
		Charset charSet = Charset.forName("Us-ASCII");
		Path filePath = FileSystems.getDefault().getPath("D:\\Files\\file1\\file1.txt");
		BufferedReader bufReader =  Files.newBufferedReader(filePath,charSet);
		String line = null;
		while((line=bufReader.readLine())!=null){
			System.out.println(line);
		}
	}
}