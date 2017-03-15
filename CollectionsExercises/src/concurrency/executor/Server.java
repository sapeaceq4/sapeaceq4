/**
 * program to illustrate `telnet server port` for connection, 
 * and use executor framework to create threads
 */
package concurrency.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
	static Executor pool = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(9000);
		
		while(true){
			Socket s = socket.accept();
			Runnable r = new Runnable() {

				@Override
				public void run() {
					try {
						doWork(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}; // end of new Runnable()
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			pool.execute(r);
			
		}
	}
	
	static void doWork(Socket socket) throws IOException {
		while(true)
			System.out.println(socket.getInputStream().read());
	}
}
