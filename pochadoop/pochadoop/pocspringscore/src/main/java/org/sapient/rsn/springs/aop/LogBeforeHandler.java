package org.sapient.rsn.springs.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class LogBeforeHandler extends BeforeExecutionHandler {

    Logger logger = Logger.getLogger(LogBeforeHandler.class.getName());

    @Override
    public void handleBefore(Object proxy, Method method, Object[] args) {
        logger.log(Level.INFO, "Execution started  for method " + method.getName() + " of class " + proxy.getClass().getName());

    }

}
