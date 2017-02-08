package com.sapient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class DBUtil {

	Connection con = null;

	Semaphore semaphore = new Semaphore(3);

	public Connection getConnection() throws Exception {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
			if(con!=null){
				System.out.println("DB connected!!");
			}else{
				System.out.println("Fail to connect DB!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection conectionObj) {
		try {
			if (conectionObj != null && !conectionObj.isClosed()) {
				conectionObj.close();
				semaphore.release();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}