package com.list.arrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomArrayListSort {
    public static void customSort(List list, char c) {
        Collections.sort(list);
        list.remove(list.indexOf(c));
        list.add(0, c);
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<Character>();
        list.add('a');
        list.add('l');
        list.add('b');
        list.add('k');
        list.add('d');
        list.add('c');
        list.add('k');
        customSort(list, 'k');

    }
}
