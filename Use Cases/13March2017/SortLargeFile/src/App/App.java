package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(
				"Resource\\Data.txt"));
		BufferedWriter writer = null;
		List array = new ArrayList<String>();
		String temp;

		try {

			temp = reader.readLine();
			int i = 0;
			int j = 0;

			while (temp != null) {
				temp = reader.readLine();
				i = i % 10;
				array.add(temp);
				if (i == 9) {
					Collections.sort(array);
					try {
						writer = new BufferedWriter(new FileWriter(
								"Resource\\Temp\\DataPart" + j + ".txt"));
						for (int k = 0; k < array.size(); k++) {
							writer.write(array.get(k).toString() + "\n");
						}
						writer.flush();
					} finally {
						writer.close();
					}
					j++;
					array.clear();
				}
				i++;
			}

		} finally {
			reader.close();
		}

		System.out.println();

	}
}
