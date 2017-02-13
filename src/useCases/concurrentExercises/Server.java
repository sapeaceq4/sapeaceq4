package useCases.concurrentExercises;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
	
	static Executor pool = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(9191);
		
		while(true){
			final Socket s = socket.accept();
			
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					doWork(s);
					
				}
			};
			pool.execute(r);
		}
	}
	
	static void doWork(Socket s){
		try {
			System.out.println("incoming request is : "+s.getInputStream().toString());
		} catch (IOException e) {
			System.out.println("Not able to read from request");
			e.printStackTrace();
		}
		
	}

}
