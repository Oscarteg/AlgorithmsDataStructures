package main.algorithms.sorting;

import main.utils.SwapElementInArray;

/**
 * Created by Oscar on 08/04/2017.
 */
// Time Complexity -> O(n^2);
// Memory Complexity -> O(1);
// never use this

public class BubbleSort {

	public static <T extends Comparable> void sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			// last i elements are already in sorted
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1].compareTo(array[j]) > 0) {
					SwapElementInArray.swap(array, j - 1, j);
				}
			}
		}
	}

	/**
	 * This is simple version of in-place, stable bubble sort, whose best case is O(n) and worst Case O(n^2);
	 */
	public static <T extends Comparable> void sortSimple(T[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean sorted = true; // flag to check if any swapping made
			// last elements sorted
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1].compareTo(array[j]) > 0) {
					SwapElementInArray.swap(array, j - 1, j);
					sorted = false;
				}
			}
			// if any swapping has not occurred in the last iteration, we can say it is sorted now
			if (sorted) {
				break;
			}
		}
	}

}
