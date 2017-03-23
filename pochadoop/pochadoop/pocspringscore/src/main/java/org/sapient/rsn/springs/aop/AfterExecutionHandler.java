package org.sapient.rsn.springs.aop;

import java.lang.reflect.Method;

/**
 * Created by rsi164 on 2/6/2017.
 */
public abstract class AfterExecutionHandler extends SapInvocationHandler {

    public abstract void handleAfter(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(getTarget(), args);
        Thread.currentThread().sleep(1000);
        handleAfter(proxy, method, args);
        return result;
    }
}
