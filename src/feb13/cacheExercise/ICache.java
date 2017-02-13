package feb13.cacheExercise;


public interface  ICache {
	
	public abstract void putCache(Cacheable object);
	public abstract Cacheable getCache(Object identifier);
}