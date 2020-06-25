package com.hashing.hash;

// Java program to print subarray with sum as given sum
import java.util.*;

class FindingSumInArray {

    public static void subArraySum(int[] arr, int n, int sum) {
        // cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            // check whether cur_sum - sum = 0, if 0 it means
            // the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            // if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            // if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes " + start + " to " + end);
        }

    }
    
    public static void subArraySum1(int arr[], int length, int key) {
        Set<Integer> hs = new HashSet<>();
        int prev = key;
        for (int i = 0; i< length; i++) {
            if (hs.contains(Math.abs(prev - arr[i]))) {
                prev -= arr[i];
                System.out.println(prev);
            }
            hs.add(arr[i]);
        }
        if (hs.contains(Math.abs(prev))) {
            System.out.println("Sum exists");
        } else {
            System.out.println("Sum doesnt exists");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {15, 11, 8, 4, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 12;
        // not working for {16, 18, 39, 10} key = 28
        subArraySum(arr, n, sum);
        int arr1[] = {16, 18, 39, 10};
        n= arr1.length;
        sum = 28;
        //this will work
        subArraySum1(arr, n, sum);
    }
}
