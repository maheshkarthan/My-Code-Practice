package com.list.arrayLists;

import java.util.Arrays;

public class SegrigateBinaryArray01 {

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1, 0, 1 };
         int count = 0;
         for (int i = 0; i< arr.length; i++) {
             if (arr[i] == 0) {
                 int temp = arr[i];
                 arr[i] = arr[count];
                 arr[count] = temp;
                 count++;
             }
         }
         System.out.println(Arrays.toString(arr));
    }
}
