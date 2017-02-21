import java.io.File;

import org.rohit.utility.FileUtility;


public class SortLargeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("text.txt");
		FileUtility.splitFile(file, 5); 

	}

}
