package com.sapient.ace.classroom.jms;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class JMSContext {
    private InitialContext context;
    public final static String destination ="dynamicQueues/TestQ";

    public Context init() throws NamingException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
        InitialContext ctx = new InitialContext(props);
        return ctx;
    }

    public void close(){
        if (context != null) {
            try {
                context.close();
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }

    }

}
