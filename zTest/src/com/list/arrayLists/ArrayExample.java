package com.list.arrayLists;

import java.util.*; 

public class ArrayExample { 
  
  
// Function to replace the elements 
static void ReplaceElements(int arr[], int n) 
{ 
    // Max value initialised 
    // to element at 0th index 
    int max_ele = arr[0]; 
    arr[0] = -1; 
  
    for (int i = 1; i < n; ++i) { 
  
        // If max_ele is greater tha arr[i] 
        // then just replace arr[i] with max_ele 
        if (max_ele > arr[i]) 
            arr[i] = max_ele; 
  
        // Else if update the max_ele also 
        else if (max_ele <= arr[i]) { 
            int temp = arr[i]; 
            arr[i] = max_ele; 
            max_ele = temp; 
        } 
    } 
    System.out.println(Arrays.toString(arr));
} 

static int did(int i, int j, int k) {
    int dist = 0;
    
    for (int l = 0; l< i; l++) {
        if(l >= k -1) {
            if(j == 0) {
                dist = l;
                return dist;
            }
            j--;
        }
    }
    return dist;
}
  
// Driver code 
public static void main(String args[]) 
{ 
    int arr[] = { 4, 5, 2, 1, 7, 6 }; 
    int n = arr.length; 
    int i = 0;
    int arrSample[] = new int[10];
    arrSample[i++] = 2;
    arrSample[i++] = 4;
    i--;
  
    // Replace the elements 
    // with the smaller element 
    // on its left side 
    ReplaceElements(arr, n); 
    System.out.println(Integer.MIN_VALUE+"  "+Integer.MAX_VALUE);
  System.out.println(did(5, 2, 4));
    // Print the modified array 
    /*for (int i = 0; i < n; ++i) 
        System.out.println(arr[i]); */
} 
} 