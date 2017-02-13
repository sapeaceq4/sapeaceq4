package feb13.cacheExercise;

public class TestMainApplicationCache {
	
	public static void main(String[] args) throws InterruptedException {
		
		ReadWriteCache cache = new ReadWriteCache();
		String s = new String("This is Test Object");
		CachedObject co = new CachedObject(s, new Long(1234),1);
		cache.putCache(co);
		CachedObject o = (CachedObject)cache.getCache(new Long(1234));
		System.out.println("Cache entry found : " +o.getCachedObject().toString());
		//put on sleep so that cache manger can remove expired object
		Thread.sleep(80000);
		
		o = (CachedObject)cache.getCache(new Long(1234));
		System.out.println("Cache Expired After 80 seconds object found in map is : " +o);
	}

}
