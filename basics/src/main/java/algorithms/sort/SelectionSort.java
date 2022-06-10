package algorithms.sort;

import java.util.Arrays;

/*
	1) Has worst kind of sorting in the recent.
	2) Since timecomplexity is bad, its pretty much obvious that the space complexity must be
	good since space was least utelized.
	3) Best, Average and Worst --> O (n^2). It's a quadratic time complexity.
 */
/*
	URL : https://www.geeksforgeeks.org/selection-sort/
	Space Complexity : O (1)
	Time Complexity : O(n^2)
*/
public class SelectionSort {

	public void sort(int arr[]) {
		int n = arr.length;

		// compare to bubble sort this is just avoiding swapping every time.
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			// Finally swap for this iteration. Only difference b/w this and bubble sort is this step is outside here.
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = {7, 3, 1, 2, 8};
		SelectionSort sort = new SelectionSort();

		long startTime = System.nanoTime();
		sort.sort(arr);
		System.out.println("Time taken : " + (System.nanoTime() - startTime));

		Arrays.stream(arr).forEach(System.out::println);
	}
}