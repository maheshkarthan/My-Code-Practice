package com.list.arrayLists;

public class FindMissingAndRepeatingElements {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 1, 6, 2};
        int n = arr.length;
        int Sum_N = (n * (n + 1)) / 2; // (n(n+1))/2
        int Sum_NSq = (n * (n + 1) * (2 * n + 1)) / 6; // (n(n+1) * (2n+1))/6
        int missingNumber = 0, repeating = 0;

        for (int i = 0; i < arr.length; i++) {
            Sum_N -= arr[i];
            Sum_NSq -= arr[i] * arr[i];
        }

        missingNumber = (Sum_N + Sum_NSq / Sum_N) / 2; // (firstFormulaVal + secondFormulaVal/firstFormulaVal)/2
        repeating = missingNumber - Sum_N;
        System.out.println(repeating + " " + missingNumber);
    }
}
