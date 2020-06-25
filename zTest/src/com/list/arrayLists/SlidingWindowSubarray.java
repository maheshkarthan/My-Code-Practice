package com.list.arrayLists;

public class SlidingWindowSubarray {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int windowSize = 2;
        int sum = 6;

        int sumSoFar = 0;
        for (int i = 0; i < windowSize; i++) {
            sumSoFar += arr[i];
            if (sumSoFar == sum) {
                System.out.println("Array with Sum found from indexs: " + 0 + " " + i);
            }
        }

        for (int i = windowSize; i < arr.length; i++) {
            sumSoFar = sumSoFar + arr[i] - arr[i - windowSize];
            if (sumSoFar == sum) {
                System.out.println("Array with Sum found from indexs: " + (i - (windowSize - 1)) + " " + i);
            }
        }
    }
}
//O(n)