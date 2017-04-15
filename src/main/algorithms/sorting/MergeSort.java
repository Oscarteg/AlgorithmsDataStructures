package main.algorithms.sorting;

/**
 * Created by Oscar on 08/04/2017.
 */
public class MergeSort {

	// TODO fix with generics
	public static <T extends Comparable> void sort(T[] a) {
//        T[] helper = new ArrayList();
//        sort(a, 0, a.length - 1, helper);
//        Map map = new HashMap<>();
	}

	private static <T extends Comparable> void sort(T[] a, int lo, int hi, T[] helper) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid, helper);
		sort(a, mid + 1, hi, helper);
		merge(a, lo, mid, hi, helper);
	}

	private static <T extends Comparable> void merge(T[] a, int lo, int mid, int hi, T[] helper) {
		for (int i = lo; i <= hi; i++) {
			helper[i] = a[i];
		}

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = helper[j++];
			} else if (j > hi) {
				a[k] = helper[i++];
			} else if (helper[i].compareTo(helper[j]) <= 1) {
				a[k] = helper[i++];
			} else {
				a[k] = helper[j++];
			}
		}

	}

}
