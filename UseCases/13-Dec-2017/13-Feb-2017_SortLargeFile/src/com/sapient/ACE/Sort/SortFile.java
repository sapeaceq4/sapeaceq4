package com.sapient.ACE.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SortFile {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("resource\\LargeFile"));
		String s = "";
		int count = 1;
		int index = 0;
		int fileNameCounter = 0;
		String[] sortArray = new String[5];
		while ((s = br.readLine()) != null) {
			sortArray[index] = s;
			count++;
			index++;
			if ((count - 1) % 5 == 0) {
				fileNameCounter++;
				Arrays.sort(sortArray);
				count = 1;
				index = 0;
				BufferedWriter bw = new BufferedWriter(new FileWriter("resource\\file_" + fileNameCounter));
				for (int wr = 0; wr < sortArray.length; wr++) {
					bw.write(sortArray[wr]);
					if (wr != sortArray.length - 1)
						bw.write("\n");
				}
				bw.flush();
			}

		}
	}

}
