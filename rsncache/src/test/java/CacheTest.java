import com.sapient.cache.Cache;
import com.sapient.cache.CacheElement;
import com.sapient.cache.manager.CacheManager;
import com.sapient.cache.notification.CacheNotificationListener;
import com.sapient.cache.notification.Notification;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Ravdeep Singh
 */
public class CacheTest {
    private static Cache<Integer, String> timedCache;
    private static Cache<Integer, String> sizeCache;

    private static CacheNotificationListener cacheNotificationListener = new CacheNotificationListener(new Notification("Notification Message"));

    @BeforeClass
    public static void initCache() {
        timedCache = CacheManager.getCache(10, "time", cacheNotificationListener);
        sizeCache = CacheManager.getCache(5, "size", cacheNotificationListener);
    }

    @AfterClass
    public static void stopEvictor() {
        CacheManager.shutdownEvictor();
    }

    @Before
    public void setup() {
        timedCache.clear();
        sizeCache.clear();
    }

    /**
     * This tests whether the expired entries are evicted
     */
    @Test
    public void timedCacheOnExpiryShouldPass() {
        CacheElement<String> valueOne = new CacheElement<>("value One", 1);
        CacheElement<String> valueTwo = new CacheElement<>("value two", 60);
        timedCache.put(1, valueOne);
        threadSleep(4);
        timedCache.put(2, valueTwo);
        threadSleep(25);
        assertNull(timedCache.get(1));
        assertNotNull(timedCache.get(2));
//        verify(cacheNotificationListener, times(1)).update(timedCache, valueOne);
    }


    @Test
    public void sizeCacheOnExpiryShouldPass() {
        insertValues();
        threadSleep(30);
        CacheElement<String> value = new CacheElement<>("value two", 600);
        sizeCache.put(15, value);
        assertNull(sizeCache.get(0));
        assertNotNull(sizeCache.get(15));
    }

    private void insertValues() {

        for (int i = 0; i < 5; i++) {
            sizeCache.put(i, new CacheElement<>("value-" + i, i + 10));
        }
    }

    private void threadSleep(int seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
