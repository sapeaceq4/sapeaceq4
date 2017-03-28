import com.sapient.cache.Cache;
import com.sapient.cache.CacheElement;
import com.sapient.cache.exception.CacheException;
import com.sapient.cache.manager.CacheManager;
import com.sapient.cache.notification.CacheNotificationListener;
import com.sapient.cache.notification.Notification;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Ravdeep Singh
 */
public class CacheTest {
    private static Cache<Integer, String> timedCache;
    private static Cache<Integer, String> sizeCache;

    private static CacheNotificationListener cacheNotificationListener = new CacheNotificationListener(new Notification("Notification Message"));

    @BeforeClass
    public static void initCache() {
        timedCache = CacheManager.MANAGER.getCache(10, "time", cacheNotificationListener);
        sizeCache = CacheManager.MANAGER.getCache(5, "size", cacheNotificationListener);
    }

    @AfterClass
    public static void stopEvictor() {
        CacheManager.MANAGER.shutdownEvictor();
    }

    @Before
    public void setup() {
        timedCache.clear();
        sizeCache.clear();
    }

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
    }

    @Test
    public void timedCacheNotificationOnExpiryShouldPass() {
        CacheNotificationListener notificationListener = Mockito.mock(CacheNotificationListener.class);
        Cache<Integer,String > cache = CacheManager.MANAGER.getCache(10, "time", notificationListener);
        CacheElement<String> value = new CacheElement<>("value-" + 0, 5);
        cache.put(1, value);
        threadSleep(20);
        assertNull(cache.get(1));
        verify(notificationListener, times(1)).update(cache, value);
        cache.clear();
    }


    @Test(expected = CacheException.class)
    public void cacheWithNullNotificationListenerShouldThrowException() {
        CacheNotificationListener notificationListener = null;
        Cache<Integer,String >  cache = CacheManager.MANAGER.getCache(10, "time", notificationListener);
        CacheElement<String> value = new CacheElement<>("value-" + 0, 5);
        cache.put(1, value);
        threadSleep(20);
        assertNull(cache.get(1));
        verify(notificationListener, times(1)).update(cache, value);
        cache.clear();
    }

    @Test(expected = CacheException.class)
    public void cacheFullWithNoExpiredElementsShouldThrowException() {
        CacheNotificationListener notificationListener = Mockito.mock(CacheNotificationListener.class);
        Cache<Integer,String >  cache = CacheManager.MANAGER.getCache(10, "size", notificationListener);
        CacheElement<String> value = new CacheElement<>("value-" + 0, 5);
        insertValues(11, cache, false);
        threadSleep(20);
        assertNotNull(cache.get(1));
        verify(notificationListener, times(1)).update(cache, value);
        cache.clear();
    }


    @Test
    public void sizeCacheOnExpiryShouldPass() {
        insertValues(5, sizeCache, true);
        threadSleep(30);
        CacheElement<String> value = new CacheElement<>("value two", 600);
        sizeCache.put(15, value);
        assertNull(sizeCache.get(0));
        assertNotNull(sizeCache.get(15));
    }

    private void insertValues(int number,  Cache<Integer,String >  cache, boolean expirable) {
        for (int i = 0; i < number; i++) {
            if (expirable)
                cache.put(i, new CacheElement<>("value-" + i, i + 10));
            else
                cache.put(i, new CacheElement<>("value-" + i));
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
