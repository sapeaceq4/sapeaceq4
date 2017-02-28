package me.learn.domain.criteria;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class HibernateEventListner implements LoadEventListener{

	public HibernateEventListner() {
	}

	@Override
	public void onLoad(LoadEvent event, LoadType loadType)
			throws HibernateException {
		System.out.println(event.getEntityClassName());
		
	}

}
