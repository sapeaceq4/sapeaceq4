package com.sapient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.TimerTask;

public class TestApplication2 extends TimerTask implements Runnable {

	@Override
	public void run() {
		try {
			ProductDetail pdetails = ProductDetail.getInstance();
			pdetails.getProductDetails().clear();
			ReadFilesUtil.listFilesAndFilesSubDirectories("D:\\Files\\");
			try {
				updateProductDetailInDB(pdetails.getProductDetails());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void updateProductDetailInDB(List<Product> prdList) throws Exception {
		Connection conn = new DBUtil().getConnection();

		PreparedStatement prepStmt = conn.prepareStatement("update product_detail set product_cost = ? where product_code = ?");
		for (Product product : prdList) {
			prepStmt.setDouble(1, product.getProductCost());
			prepStmt.setString(2, product.getProductCode());
			prepStmt.addBatch();
		}

		 int [] numUpdates=prepStmt.executeBatch();             
		  for (int i=0; i < numUpdates.length; i++) {            
		    if (numUpdates[i] == -2)
		      System.out.println("Execution " + i + 
		        ": unknown number of rows updated");
		    else
		      System.out.println("Execution " + i + "successful: " +numUpdates[i] + " rows updated");
		  }	
		  conn.close();
	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * ReadFilesUtil.listFilesAndFilesSubDirectories("D:\\Files\\"); }
	 */
}
