package org.om.aec.jsm;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmxContext 
{
	public static final String QUEUE_NAME = "dynamicQueues/TestQ";
	
	private InitialContext context;
	
	public Context init() throws NamingException 
	{
	    Properties props = new Properties();
	    props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	    props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
	    context = new InitialContext(props);
	    return context;
	}
	
	
	public void stop()
	{
		if(context != null)
		{
			try 
			{
				context.close();
			} 
			catch (NamingException e)
			{
				e.printStackTrace();
			}
		}
	}
}
