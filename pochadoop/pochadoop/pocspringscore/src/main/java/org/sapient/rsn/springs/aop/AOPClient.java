package org.sapient.rsn.springs.aop;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class AOPClient {
    public static void main(String[] args) {

        CalculatorImpl calcImpl = new CalculatorImpl();
        LogBeforeHandler before = new LogBeforeHandler();
        LogAfterHandler after = new LogAfterHandler();
        after.setTarget(calcImpl);
        before.setTarget(calcImpl);

        ArrayList<SapInvocationHandler> handlers = new ArrayList<>();

        handlers.add(before);
        handlers.add(after);

        Calculator proxy = (Calculator) ProxyFactory.getProxy(calcImpl,  handlers);
//        Join point

//        Calculator proxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, after);
        System.out.println(proxy.add(20, 10));
   }
}
