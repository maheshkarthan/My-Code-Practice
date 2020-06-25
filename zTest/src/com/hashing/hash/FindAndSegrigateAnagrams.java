package com.hashing.hash;

// Java program to print anagrams
// together using dictionary
import java.util.*;
import java.util.Map.Entry;

public class FindAndSegrigateAnagrams {

    private static void printAnagrams(String arr[]) {
        HashMap<String, List<String>> map = new HashMap<>();

        // loop over all words
        for (int i = 0; i < arr.length; i++) {

            // convert to char array, sort and
            // then re-convert to string
            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            // calculate hashcode of string
            // after sorting
            // int n = newWord.hashCode(); can use key as hashcode
            if (map.containsKey(newWord)) {

                // Here, we already have
                // a word for the hashcode
                List<String> words = map.get(newWord);
                words.add(word);
                map.put(newWord, words);
            } else {

                // This is the first time we are
                // adding a word for a specific
                // hashcode
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        // print all the values where size is > 1
        // If you want to print non-anagrams,
        // just print the values having size = 1
        for (Entry<String, List<String>> i : map.entrySet()) {
            System.out.println(i.getKey() + " : " + i.getValue());
        }
    }

    public static void main(String[] args) {

        // Driver program
        String arr[] = {"cat", "dog", "tac", "god", "act"};
        printAnagrams(arr);
    }
}
