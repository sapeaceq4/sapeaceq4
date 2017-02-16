package org.om.aec.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain 
{
	public static void main(String[] args)
	{
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		Address address = applicationContext.getBean("presentAddress", Address.class);
		System.out.println(address);
		
		((AbstractApplicationContext)applicationContext).registerShutdownHook();
	}
}
