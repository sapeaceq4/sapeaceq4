package org.sapient.rsn.interviews.reflection.proxy;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rsi164 on 2/7/2017.
 */
public class FileParser implements Parser<String> {

    @Override
    public Collection<String> parse() {

        return Arrays.asList("1","2","3","4","5","6","7","8");
    }
}
