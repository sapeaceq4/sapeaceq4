package com.tridatastructure.readbigfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		//readfile();
//		readBigDataFile();
		//byteChannelRead();
		fileChannelRead();
		
	}

	private static void readBigDataFile() throws FileNotFoundException, IOException {
		RandomAccessFile ranfile = new RandomAccessFile("C:\\Users\\ssh200\\Desktop\\links.txt", "r");
		FileChannel fileChannel = ranfile.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (fileChannel.read(buffer) > 0) {
			buffer.flip();
			for (int i = 0; i < buffer.limit(); i++) {
				//System.out.println((char) buffer.get());
			}
			buffer.clear();
		}
		fileChannel.close();
		ranfile.close();
	}
	
	private static void readfile() throws IOException{
		Charset charSet = Charset.forName("Us-ASCII");
		Path filePath = FileSystems.getDefault().getPath("C:\\Users\\ssh200\\Desktop\\links.txt");
		BufferedReader bufReader =  Files.newBufferedReader(filePath,charSet);
		String line = null;
		while((line=bufReader.readLine())!=null){
			System.out.println(line);
		}
	}
	
	public static void byteChannelRead() throws IOException {
		Path filePath = FileSystems.getDefault().getPath("C:\\Users\\ssh200\\Desktop\\links.txt");
		SeekableByteChannel byteChannel = Files.newByteChannel(filePath);
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		Charset charset = Charset.forName("US-ASCII");
		while (byteChannel.read(byteBuffer) > 0) {
			byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			byteBuffer.flip();
		}
	}
	
	public static void fileChannelRead() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\ssh200\\Desktop\\links.txt","rw");
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
}
