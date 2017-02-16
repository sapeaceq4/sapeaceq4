package com.sapient.ace.proxy;

import java.util.Collection;

/**
 * Created by rsi164 on 2/7/2017.
 */
public interface Parser<T> {
    public Collection<T> parse();
}
