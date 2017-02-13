package feb13.cacheExercise;

public enum CacheConstants{
	DEFAULT_OBJECT_LIFE(1),
	DEFAULT_OBJECT_EXPIRETIME(1),
	MAX_CACHE_SIZE(5);
	private int value;
	
	CacheConstants(int value){
		this.value=value;
	}

	public int getValue() {
		return value;
	}
}
