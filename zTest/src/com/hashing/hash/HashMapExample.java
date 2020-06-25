package com.hashing.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<>();
        System.out.println("Hellooo " + hm.put("HAI", "HELLO")); // Here this will return null
        System.out.println("HHHH " + hm.put("HAI", "HELL"));// This will return previous value "HELLO"
        hm.put("Hi", "you");

        // This will return Concurrent modification exception because we are Adding new entry while traversing.
        // Modifiying existing elements is allowing
        // throwing exception, if HashMap is not changed to ConcurrentHashMap
        for (Map.Entry<String, String> string : hm.entrySet()) {
            hm.put("HAII", string.getKey());
        }
        System.out.println(hm);

        // concurrent hashmap does't allow null key or null value's
        Map<String, String> hhh = new ConcurrentHashMap<String, String>();
        hhh.put(null, "jj");
    }

}
