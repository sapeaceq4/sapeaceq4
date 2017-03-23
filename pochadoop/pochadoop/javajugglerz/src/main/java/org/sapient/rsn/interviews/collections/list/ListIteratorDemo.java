package org.sapient.rsn.interviews.collections.list;

import java.util.*;

/**
 * Created by rsi164 on 2/6/2017.
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
//        List<String> nameList = Arrays.asList("sos","pk","rajjo","chirag","anna","gulam");
        List<String> nameList = new ArrayList<>();
        nameList.add("sos");
        nameList.add("pk");
        nameList.add("rajjo");
        nameList.add("chirag");
        nameList.add("gulam");

        removingUsingForEach(nameList);
//        removingUsingIterator(nameList);
//        removingUsingListIterator(nameList);
        System.out.println(nameList);

    }

    private static void removingUsingIterator(List<String> nameList) {
        for (Iterator<String> iter = nameList.iterator(); iter.hasNext(); ) {
            String element = iter.next();
            if (element.equals("gulam"))
                iter.remove();
//                nameList.add("test");
        }
    }

    private static void removingUsingListIterator(List<String> nameList) {
        for (ListIterator<String> iter = nameList.listIterator(); iter.hasNext(); ) {
            String element = iter.next();
            if (element.equals("gulam")) {
                iter.remove();
                iter.add("test");
            }
        }

    }

    private static void removingUsingForEach(List<String> nameList) {
        for (String name : nameList) {
            if (name.equals("gulam")) {
                nameList.remove("gulam");
            }
        }

    }
}
