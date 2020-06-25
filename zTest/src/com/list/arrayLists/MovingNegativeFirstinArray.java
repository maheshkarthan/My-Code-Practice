package com.list.arrayLists;

public class MovingNegativeFirstinArray {
    
    int[] swapByNegativity(int arr[], int len) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != count) {
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] =  temp;
                    count++;
                }
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 9, -13, -5, 6, -7, 5, -3, -6} ;
        int length = arr.length;
        MovingNegativeFirstinArray anfa = new MovingNegativeFirstinArray();
        arr = anfa.swapByNegativity(arr, length);
        for (int i = 0; i < arr.length; i++) {
            
            System.out.print(" "+arr[i]);
        }
    }
}
