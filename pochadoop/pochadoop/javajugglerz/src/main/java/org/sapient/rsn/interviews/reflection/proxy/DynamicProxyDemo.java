package org.sapient.rsn.interviews.reflection.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by rsi164 on 2/7/2017.
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //Create proxy object
        Parser parser = (Parser) Proxy.newProxyInstance(Parser.class.getClassLoader(),new Class<?>[]{Parser.class},
                new ParserInvocationHandler(new FileParser()));


        System.out.printf("t.parse(): %s%n", parser.parse());
        System.out.printf("t.toString(): %s%n", parser);
        System.out.printf("t.hashCode(): %H%n", parser);
        System.out.printf("t.equals(t): %B%n", parser.equals(parser));
        System.out.printf("t.equals(new Object()): %B%n", parser.equals(new Object()));
        System.out.printf("t.equals(null): %B%n", parser.equals(null));

    }
}
