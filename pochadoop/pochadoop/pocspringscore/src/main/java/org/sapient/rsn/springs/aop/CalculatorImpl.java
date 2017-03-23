package org.sapient.rsn.springs.aop;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
