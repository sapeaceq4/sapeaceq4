package com.sapient.ace.collections;

/**
 * Created by Ravdeep Singh on 15-02-2017.
 */


import java.util.*;

public class MapUtils {
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 30);
        map.put("c", 50);
        map.put("d", 40);
        map.put("e", 20);
        System.out.println(map);

        Map sortedMap = sortByValue(map);
        System.out.println(sortedMap);
    }
}