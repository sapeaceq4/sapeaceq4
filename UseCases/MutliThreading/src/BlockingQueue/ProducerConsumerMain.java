package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerConsumerMain {

    public static void main(String args[]){
     //Creating shared object
     BlockingQueue sharedQueue = new ArrayBlockingQueue(10);
 
     Thread prodThread = new Thread(new Producer(sharedQueue));
     Thread consThread = new Thread(new Consumer(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}

