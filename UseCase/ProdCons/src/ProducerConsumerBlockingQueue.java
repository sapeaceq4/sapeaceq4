import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 

class ProducerBlockingQueue implements Runnable {
 
    private final BlockingQueue<Integer> sharedQueue;
 
    public ProducerBlockingQueue(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
         try {
             System.out.println("Produced : " + i);
             sharedQueue.put(i);          
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
}
 
/**
 * Consumer Class in java.
 */
class ConsumerBlockingQueue implements Runnable{
 
    private BlockingQueue<Integer> sharedQueue;
 
    public ConsumerBlockingQueue (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        while(true){
         try {
             System.out.println("CONSUMED : "+ sharedQueue.take());  
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
 
}
public class ProducerConsumerBlockingQueue {
 
    public static void main(String args[]){
     
     //Creating shared object  
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
    
     ProducerBlockingQueue producer=new ProducerBlockingQueue(sharedQueue);
     ConsumerBlockingQueue consumer=new ConsumerBlockingQueue(sharedQueue);
    
     Thread producerThread = new Thread(producer, "ProducerThread");
     Thread consumerThread = new Thread(consumer, "ConsumerThread");
     producerThread.start();
     consumerThread.start();
 
    }
 
}
 