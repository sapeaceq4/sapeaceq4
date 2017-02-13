package com.sapient.ace.cache;

import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable{

	private Date dateofExpiration = null;
	private Object identifier = null;
	public Object object = null;

	public CachedObject(Object obj, Object id, int minutesToLive)
	    {
	      this.object = obj;
	      this.identifier = id;
	      if (minutesToLive != 0)
	      {
	        dateofExpiration = new java.util.Date();
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(dateofExpiration);
	        cal.add(Calendar.MINUTE, minutesToLive);
	        dateofExpiration = cal.getTime();
	      }
	    }

	public boolean isExpired() {
		if (dateofExpiration != null) {
			if (dateofExpiration.before(new java.util.Date())) {
				System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: "
						+ dateofExpiration.toString() + " CURRENT TIME: " + (new java.util.Date()).toString());
				return true;
			} else {
				System.out.println("CachedResultSet.isExpired:  Expired not from Cache!");
				return false;
			}
		} else // This means it lives forever!
			return false;
	}

	public Object getIdentifier() {
		return identifier;
	}
}
