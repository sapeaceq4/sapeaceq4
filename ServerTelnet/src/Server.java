import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
	static Executor pool = Executors.newFixedThreadPool(5);
	
	public static void main(String[]  args) throws IOException {
		ServerSocket socket = new ServerSocket(8700);
		while(true) {
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
		//System.out.println("in dowork");
		//System.out.println(s.toString());
		
		
		try {
			while(true){
				System.out.println((char)s.getInputStream().read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
