package GenericBQ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

       public static void main(String args[]) {
              // Creating shared object
              BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

              // Creating Producer and Consumer Thread
              Thread prodThread = new Thread(new Producer<Integer>(sharedQueue));
              Thread consThread = new Thread(new Consumer<Integer>(sharedQueue));
              // Starting producer and Consumer thread
              prodThread.start();
              consThread.start();
       }

}

class Producer<T> implements Runnable {
 
	T a;
       private  BlockingQueue sharedQueue;

       public Producer(BlockingQueue sharedQueue) {
              this.sharedQueue = sharedQueue;
       }

       @Override
       public void run() {
              for (int i = 0; i < 10; i++) {
                     try {
                           System.out.println("Produced: " + i);
                           sharedQueue.put(i);
                           Thread.sleep(100);
                     } catch (Exception ex) {
                     }
              }
       }
}

// Consumer Class in Java
class Consumer<T> implements Runnable {

       private final BlockingQueue<T> sharedQueue;

       public Consumer(BlockingQueue<T> sharedQueue) {
              this.sharedQueue = sharedQueue;
       }

       @Override
       public void run() {
              while (true) {
                     try {
                           System.out.println("Consumed: " + sharedQueue.take());
                     } catch (InterruptedException ex) {
                     }
              }
       }
}

