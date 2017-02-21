import javax.naming.NamingException;


public class SendMessage {

	public static void main(String[] args) {
		try {
			SenderReceiver.sendMessage();
			Thread.currentThread().sleep(10000);
			SenderReceiver.receiveMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
