package com.string.strings;

public class GivenStringInaString {
    public static void main(String[] args) {
        String s1 = "aabaacaadaabaaba";
        String s2 = "aaba";

        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            int count = 0;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + count) == s2.charAt(j)) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }
            if (count == s2.length()) {
                System.out.print(i);
            }
        }
    }
}
