package org.om.aec.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextProvider 
{
	public static ApplicationContext getApplicationContext()
	{
		return new ClassPathXmlApplicationContext(new String[]{"dao-context.xml"});
	}
}
