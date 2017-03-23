package org.sapient.rsn.springs.aop;

import java.lang.reflect.Method;

/**
 * Created by rsi164 on 2/6/2017.
 */
public abstract class BeforeExecutionHandler extends SapInvocationHandler {

    public abstract void handleBefore(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleBefore(proxy, method, args);
        Thread.currentThread().sleep(1000);
        Object result = method.invoke(getTarget(), args);
        return result;
    }
}
