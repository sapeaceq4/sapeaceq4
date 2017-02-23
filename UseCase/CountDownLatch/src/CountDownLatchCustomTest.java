
class CountDownLatchCustom{
 
    private int count;
   
    public CountDownLatchCustom(int count) {
           this.count=count;
    }
 
    public synchronized void await() throws InterruptedException {
           //If count is greater than 0, thread waits.
           if(count>0)
                  this.wait();
    }
 
    /**
     *  Reduces latch count by 1.
     *  If count reaches 0, all waiting threads are released.
     */
    public synchronized void countDown() {
           //decrement the count by 1.
           count--;
           
           //If count is equal to 0, notify all waiting threads.
           if(count == 0)
                  this.notifyAll();
    }
    
}

/**
 * Main class
 */
public class CountDownLatchCustomTest {
    
    public static void main(String[] args) {
           CountDownLatchCustom countDownLatchCustom=new CountDownLatchCustom(3);
           System.out.println("CountDownLatch has been created with count=3");
           new Thread(new MyRunnable(countDownLatchCustom)).start();
           try {
                  countDownLatchCustom.await();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           System.out.println("count has reached zero, "+
                        Thread.currentThread().getName()+" thread has ended");
 
    }
 
}
class MyRunnable implements Runnable{
    
    CountDownLatchCustom countDownLatchCustom;
    
    MyRunnable(CountDownLatchCustom countDownLatchCustom){
           this.countDownLatchCustom=countDownLatchCustom;
    }
    
    public void run(){
           
           for(int i=2;i>=0;i--){
                  
                  countDownLatchCustom.countDown();            
                  System.out.println(Thread.currentThread().getName()+
                               " has reduced latch count to : "+ i);
                  
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }
                  
    }
    
}