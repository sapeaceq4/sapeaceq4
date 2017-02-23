public class CyclicBarrierCustomTest {
	
	
    public static void main(String[] args) {
           /*
            * Create CountDownLatch with 3 parties, when all 3 parties
            * will reach common barrier point CyclicBarrrierEvent will be
            * triggered i.e. run() method of CyclicBarrrierEvent will be called
            */
           CyclicBarrierCustom cyclicBarrierCustom=new CyclicBarrierCustom(3 ,new CyclicBarrrierEvent());
           System.out.println("CountDownLatch has been created with parties=3,"
                        + " when all 3 parties will reach common barrier point "
                        + "CyclicBarrrierEvent will be triggered");
 
           MyRunnable myRunnable1=new MyRunnable(cyclicBarrierCustom);
           
           //Create and start 3 threads
           new Thread(myRunnable1,"Thread-1").start();
           new Thread(myRunnable1,"Thread-2").start();
           new Thread(myRunnable1,"Thread-3").start();
    
           
           
    }
 
}

class MyRunnable implements Runnable{
 
    CyclicBarrierCustom cyclicBarrierCustom;
    
    MyRunnable(CyclicBarrierCustom cyclicBarrierCustom){
           this.cyclicBarrierCustom=cyclicBarrierCustom;
    }
    
    @Override
    public void run() {
           
           System.out.println(Thread.currentThread().getName() +
                        " is waiting for all other threads to reach common barrier");
           try {
                  Thread.sleep(1000);
                  cyclicBarrierCustom.await();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println("As all threads have reached common barrier "
                        + Thread.currentThread().getName() +
                        " has been released");
    }
    
}

class CyclicBarrrierEvent implements Runnable{
 
    public void run() {
           System.out.println("As all threads have reached common barrier point "
                        + ", CyclicBarrrierEvent has been triggered");
    }
    
}