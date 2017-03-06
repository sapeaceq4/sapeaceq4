package com.sapient.ace.Utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Ravdeep Singh on 2/27/2017.
 */
public class UnsafeClazz {
    private String rdx;
    public static void main(String[] args) throws NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe"); //Internal reference
        f.setAccessible(true);
    }
}
