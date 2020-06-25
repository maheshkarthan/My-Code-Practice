package com.list.arrayLists;

public class MaxDifferenceInArray {

    // Java program to find Maximum
    // difference between two elements
    // such that larger element appears
    // after the smaller number

    /*
     * The function assumes that there are at least two elements in array. The
     * function returns a negative value if the array is sorted in decreasing
     * order and returns 0 if elements are equal
     */
    static int maxDiff(int arr[], int n) {
        // Initialize diff, current
        // sum and max sum
        int diff = arr[1] - arr[0];
        int curr_sum = diff;
        int max_sum = curr_sum;

        for (int i = 1; i < n - 1; i++) {
            // Calculate current diff
            diff = arr[i + 1] - arr[i];
            //System.out.println(curr_sum+"  "+diff);
            // Calculate current sum
            if (curr_sum > 0)
                curr_sum += diff; // adding all the differences when the previous difference is > 0
            else
                curr_sum = diff; // else resetting the difference to current difference
        }
        // Update max sum, if needed
        if (curr_sum > max_sum)
            max_sum = curr_sum;

        return max_sum;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {80, 2, 6, 3, 100};
        int n = arr.length;

        // Function calling
        System.out.print("Maximum difference is " + maxDiff(arr, n));
    }
}