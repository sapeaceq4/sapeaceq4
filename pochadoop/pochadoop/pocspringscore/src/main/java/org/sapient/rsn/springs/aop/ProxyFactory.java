package org.sapient.rsn.springs.aop;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class ProxyFactory {
    public static Object getProxy(Object targetObject, List<SapInvocationHandler> handlers) {
        Object proxyObject = null;
        if (handlers.size() > 0) {
            proxyObject = targetObject;
            for (int i = 0; i < handlers.size(); i++) {
                handlers.get(i).setTarget(proxyObject);
                proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass()
                        .getInterfaces(), handlers.get(i));
            }
            return proxyObject;
        } else {
            return targetObject;
        }
    }
}
