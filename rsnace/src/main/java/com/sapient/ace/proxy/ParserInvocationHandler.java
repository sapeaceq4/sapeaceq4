package com.sapient.ace.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by rsi164 on 2/7/2017.
 */
public class ParserInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public ParserInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------------------ log to database-----------------");
        System.out.println( "Logging "+targetObject+" in data bases");
        System.out.println( "TargetObject "+targetObject.getClass().getName());
        System.out.println( "TargetObject "+targetObject.equals(proxy));
        System.out.println( "TargetObject "+targetObject.toString());
        System.out.println( "TargetObject "+targetObject.hashCode());
        System.out.println("------------------------ finished-----------------");

        Object ret = method.invoke(targetObject, args);
        return ret ;
    }
}
