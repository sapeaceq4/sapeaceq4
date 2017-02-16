package com.sapient.ace.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by rsi164 on 2/7/2017.
 */
public class DynamicProxyClient {
    public static void main(String[] args) {
        //Create proxy object
        final FileParser targetObject = new FileParser();
        Parser parser = (Parser) Proxy.newProxyInstance(Parser.class.getClassLoader(),new Class<?>[]{Parser.class},
                new ParserInvocationHandler(targetObject));

        System.out.printf("t.parse(): %s%n", parser.parse());
        System.out.println("Original"+targetObject.hashCode());
//        System.out.printf("t.toString(): %s%n", parser);
//        System.out.printf("t.hashCode(): %H%n", parser);
//        System.out.printf("t.equals(t): %B%n", parser.equals(parser));
//        System.out.printf("t.equals(new Object()): %B%n", parser.equals(new Object()));
//        System.out.printf("t.equals(null): %B%n", parser.equals(null));

    }
}
