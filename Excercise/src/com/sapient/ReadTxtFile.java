package com.sapient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtFile {

	public static void readTxtFile(String path) throws IOException {
		String line;
		int lineNumber = 0;

		BufferedReader bReader = new BufferedReader(new FileReader(path));
		bReader.readLine();
		 while ((line = bReader.readLine()) != null) {
	            lineNumber++;
	            String datavalue[] = line.split("\t");
	            String prodCode = datavalue[0];
	            Double price = Double.valueOf(datavalue[1]);

	            System.out.println("Product code"+prodCode+" Price "+price);
	            
	            Product p = new Product();
	            p.setProductCode(prodCode);
	            p.setProductCost(price);
	            
	            ProductDetail.getInstance().getProductDetails().add(p);
	            
	        }

	}

}
