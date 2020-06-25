package com.list.arrayLists;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int arr[] = {5, 8, 3, 7, 9, 6};

        //Reversing an Array
        int temp = 0, i = 0, k = arr.length - 1;
        while (i < k) {
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
            k--;
        }
        for (int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + " ");
        
        
        //rotation by size
        System.out.println();
        System.out.println();
        ArrayRotation.rotLeft(arr, 2);
        System.out.println(Arrays.toString(arr));
        
    }
    
    
    
    static int[] rotLeft(int[] a, int d) {
        int temp = 0;
        for (int i=0; i<d-1; i++) {
            for (int j = 0; j< a.length-1; j++) {
                if (j == 0)
                    temp = a[j];
                a[j] = a[j+1];
            }
            a[a.length-1] = temp;
        }
        return a;
    }
}
