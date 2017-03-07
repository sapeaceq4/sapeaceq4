package me.learn.domain.tablePerHierarchy;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class HibernateEventListener implements LoadEventListener {

	@Override
	public void onLoad(LoadEvent arg0, LoadType arg1) throws HibernateException {
		System.out.println("onLoad");
	}

}
