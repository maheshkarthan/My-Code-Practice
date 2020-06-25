package com.string.strings;

import java.util.HashSet;
import java.util.Set;

public class ReverseVovelsFromString {

    public static String reverseVovels(String str) {
        if (str == null || !(str.length() > 0))
            return "";

        Set<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int i = 0;
        char arr[] = str.toCharArray();
        int len = arr.length - 1;
        while (i < len) {
            if (!hs.contains(arr[i])) {
                i++;
            }
            if (!hs.contains(arr[len])) {
                len--;
            }
            if (hs.contains(arr[len]) && hs.contains(arr[i])) {
                char x = arr[len];
                arr[len] = arr[i];
                arr[i] = x;
                i++;
                len--;
            }
        }
        String str1 = new String(arr);
        System.out.println(str1);
        return str1;
    }

    public static void main(String[] args) {
        reverseVovels("temenos");
        reverseVovels("hello");
        reverseVovels("treehouse");
        reverseVovels("geeksforgeeks");
        reverseVovels("eeerooo");
        reverseVovels("iiiiiiii");
        reverseVovels(null);
        reverseVovels("");
    }
}
