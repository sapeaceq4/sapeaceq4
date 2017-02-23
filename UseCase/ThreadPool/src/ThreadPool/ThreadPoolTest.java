package ThreadPool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
 
    private BlockingQueue<Runnable> taskQueue;
   
    private boolean poolShutDownInitiated = false;
 
    public ThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
 
        //Create and start nThreads number of threads.
        for(int i=1; i<=nThreads; i++){
           ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
         threadPoolsThread.setName("Thread-"+i);
         threadPoolsThread.start();   //start thread
        }
       
    }
 
   
    /**
     * Execute the task, task must be of Runnable type.
     */
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
           throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
 
        System.out.println("task has been added.");
        this.taskQueue.put(task);
    }
 
 
    public boolean isPoolShutDownInitiated() {
           return poolShutDownInitiated;
    }
 
 
    /**
     * Initiates shutdown of ThreadPool, previously submitted tasks
     * are executed, but no new tasks will be accepted.
     */
    public synchronized void shutdown(){
       this.poolShutDownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }
 
}
 
 
/**
 * These threads are created and started from constructor of ThreadPool class.
 */
class ThreadPoolsThread extends Thread {
 
    private BlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;
 
    public ThreadPoolsThread(BlockingQueue<Runnable> queue,
                  ThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;
       
    }
 
    public void run() {
           try {
                  while (true) {    
                        System.out.println(Thread.currentThread().getName()
                                      +" is READY to execute task.");
                        
                        Runnable runnable = taskQueue.take();
                        System.out.println(Thread.currentThread().getName()
                                      +" has taken task.");
                        //Now, execute task with current thread.
                        runnable.run();                
                        
                        System.out.println(Thread.currentThread().getName()
                                      +" has EXECUTED task.");
                        
                        if(this.threadPool.isPoolShutDownInitiated()
                                      &&  this.taskQueue.size()==0){
                               this.interrupt();
                            
                               Thread.sleep(1);  
                        }
                        
                  }
           } catch (InterruptedException e) {
                  System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
           }
    }
}
 
 
/**
 * Task class which implements Runnable.
 */
class Task implements Runnable{  
    @Override
    public void run() {
           try {
                  Thread.sleep(2000);
                  System.out.println(Thread.currentThread().getName()
                               +" is executing task.");
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
    }
};
 
/**
 * Test ThreadPool.
 */
public class ThreadPoolTest{
    public static void main(String[] args) throws Exception {
           ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool 
           Runnable task=new Task();
           threadPool.execute(task);
           threadPool.execute(task);
           
           threadPool.shutdown();
    }
    
}