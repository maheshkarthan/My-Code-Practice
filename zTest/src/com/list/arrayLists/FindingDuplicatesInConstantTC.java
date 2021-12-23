// Java code to find
// Finding duplicates in O(n) time and O(1) space from an array with elements not exceeding the size of array
//Once we encounter a value in array we will make the index's value as Negative.

class FindingDuplicatesInConstantTC {
	// Function to print duplicates
	void printRepeating(int arr[], int size)
	{
		int i;
		System.out.println("The repeating elements are : ");
		
		for (i = 0; i < size; i++) {
			int j = Math.abs(arr[i]);
			if (arr[j] >= 0)
				arr[j] = -arr[j];
			else
				System.out.print(j + " ");
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		FindingDuplicatesInConstantTC duplicate = new FindingDuplicatesInConstantTC();
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		int arr_size = arr.length;

		duplicate.printRepeating(arr, arr_size);
	}
}
