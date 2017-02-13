package feb13.cacheExercise;

import java.util.Date;

public class CachedObject implements  Cacheable{

	private Object identifier = null; 
	private Object cachedObject = null;
	private Date dateOfexpiration = null;

	public CachedObject(Object obj, Object id, int lifeInMin){
		this.cachedObject = obj;
		this.identifier = id;
		dateOfexpiration = new java.util.Date();
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(dateOfexpiration);
		cal.add(java.util.Calendar.MINUTE, lifeInMin);
		dateOfexpiration = cal.getTime();
	}
	
	@Override
	public boolean isExpired() {
		if (dateOfexpiration.before(new java.util.Date()))
			return true;
		else
			return false;
	}

	@Override
	public Date getDateOfexpiration() {
		return dateOfexpiration;
	}

	public Object getIdentifier() {
		return identifier;
	}

	public Object getCachedObject() {
		return cachedObject;
	}

}
