package com.multithread.semaphore;

import java.sql.Connection;

public class SemaphoreCheck extends Thread {

	static DBUtil dbutil =  new  DBUtil();
	
	public static void main(String[] args) {
		
		
	}
	
	@Override
	public void run() {
		Connection con = dbutil.getConnection();
		System.out.println("con "+con);
		dbutil.closeConnection(con);
	}
}
