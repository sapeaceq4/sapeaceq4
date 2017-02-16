package org.om.aec.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Employee implements InitializingBean, DisposableBean, ApplicationContextAware
{
	private String name;
	private List<Address> addresses;

	public Employee(String name, List<Address> addresses)
	{
		this.name = name;
		this.addresses = addresses;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<Address> getAddress() {
		return addresses;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", addresses=" + addresses + "]";
	}

	
	public void init()
	{
		System.out.println("init-Enter/Leave");
	}
	
	public void shutdown()
	{
		System.out.println("shutdown-Enter/Leave");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception 
	{
		System.out.println("afterPropertiesSet-Enter/Leave");
	}

	@Override
	public void destroy() throws Exception 
	{
		System.out.println("destroy-Enter/Leave");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException 
	{
		System.out.println("setApplicationContext-Enter/Leave"+ applicationContext);
	}


}
