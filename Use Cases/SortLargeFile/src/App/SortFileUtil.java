package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFileUtil {

	public static void Sort(final String fileName) throws Exception {
		SplitAndSort(fileName);
		Merge(fileName);
	}

	public static void SplitAndSort(final String fileName) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		BufferedWriter writer = null;
		
		Void as;
		
		List<String> array = new ArrayList<String>();
		String temp;

		try {
			temp = reader.readLine();
			int i = 0;
			int j = 0;
			// File splitter
			while (temp != null) {
				i = i % 10;
				array.add(temp);
				if (i == 9) {
					Collections.sort(array);
					try {
						writer = new BufferedWriter(new FileWriter(
								"Resource\\Temp\\" + j + ".txt"));
						for (int k = 0; k < array.size(); k++) {
							writer.write(array.get(k) + "\n");
						}
						writer.flush();
					} finally {
						writer.close();
					}
					j++;
					array.clear();
				}
				i++;
				temp = reader.readLine();
			}
			// Merging
		} finally {
			reader.close();
		}
		System.out.println();
	}

	public static void Merge(final String fileName) throws Exception {
		int i = 0;
		File f1 = new File("Resource\\Temp\\" + i + ".txt");
		File f2 = new File("Resource\\Temp\\" + (i + 1) + ".txt");

		BufferedReader reader1 = new BufferedReader(new FileReader(f1));
		BufferedReader reader2 = new BufferedReader(new FileReader(f2));

		// i = i + 2;

		String firstFileLine = reader1.readLine();
		String secondFileLine = reader2.readLine();
		BufferedWriter writer = null;

		writer = new BufferedWriter(new FileWriter("Resource\\Temp\\" + i
				+ (i + 1) + ".txt"));

		try {
			while (true) {

				if (null == secondFileLine && null == firstFileLine) {
					break;
				}

				if ((null == secondFileLine)
						|| firstFileLine.compareTo(secondFileLine) < 0) {
					writer.write(firstFileLine + "\n");
					firstFileLine = reader1.readLine();
				} else {
					writer.write(secondFileLine + "\n");
					secondFileLine = reader2.readLine();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
			reader1.close();
			reader2.close();
			f1.delete();
			f2.delete();
		}

	}
}
