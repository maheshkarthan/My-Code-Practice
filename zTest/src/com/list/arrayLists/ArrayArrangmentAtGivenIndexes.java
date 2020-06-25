package com.list.arrayLists;

import java.util.Arrays;

public class ArrayArrangmentAtGivenIndexes {

	public static void main(String[] args) {
		int arr[] = { 50, 40, 70, 60, 90 };
		int index[] = { 3, 0, 4, 1, 2 };

		// swap both the elements of both the arrays based on the index[]
		for (int i = 0; i < index.length; i++) {
			// swap only when the index[i] value and i are not equal
			if (index[i] != i) {
				int indexTemp = index[index[i]];
				int arrDataTemp = arr[index[i]];

				index[index[i]] = index[i];
				arr[index[i]] = arr[i];

				index[i] = indexTemp;
				arr[i] = arrDataTemp;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(index));
	}

}
