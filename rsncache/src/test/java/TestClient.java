import com.sapient.cache.*;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * Created by rsi164 on 3/27/2017.
 */
public class TestClient implements Observer {

    public static void main(String[] args) {
        TestClient testClient = new TestClient();
        Cache cache = CacheManager.getCache(10, "time", testClient);

        Thread t1 = new Thread(()->{
            for (int i = 0; i <10; i++) {
                String s = new String("key-"+i);
                CacheElement<Long> co = new CacheElement<Long>(new Long(i), 3);
                cache.put(s, co);
            }

        });
        t1.start();

        CacheElement<Long> o = (CacheElement<Long>) cache.get(5);
        if (o == null)
            System.out.println("CacheManagerTestProgram.Main:  FAILURE!  Object                   not Found.");
        else
            System.out.println("CacheManagerTestProgram.Main:  SUCCESS! " + (o.toString()));

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CacheManager.shutdownEvictor();
    }

    public void update(Observable o, Object arg) {
        System.out.println("update got " + o + " " + arg);
    }


}
