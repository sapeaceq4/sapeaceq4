package org.sapient.rsn.springs.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class LogAfterHandler extends AfterExecutionHandler {

    Logger logger = Logger.getLogger(LogAfterHandler.class.getName());

    @Override
    public void handleAfter(Object proxy, Method method, Object[] args) {
        logger.log(Level.INFO, "Execution completed  for method " + method.getName() + " of class " + proxy.getClass().getName());
    }
}
