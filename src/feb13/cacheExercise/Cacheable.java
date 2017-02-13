package feb13.cacheExercise;

import java.util.Date;

public interface Cacheable {
	public Object getIdentifier();
	public boolean isExpired();
	public Date getDateOfexpiration();
}
