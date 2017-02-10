package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Server {

	static Executor pool = Executors.newFixedThreadPool(5);

	public static void main(String[] args) throws IOException {

		ServerSocket socket = new ServerSocket(9000);

		while (true) {

			final Socket s = socket.accept();
			Runnable r = new Runnable() {

				@Override
				public void run() {
					dowork(s);

				}
			};
			pool.execute(r);
		}

	}

	static void dowork(Socket s) {
		System.out.println("processing request");
		try {
			String result = new BufferedReader(new InputStreamReader(
					s.getInputStream())).lines().collect(
					Collectors.joining("\n"));

			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
