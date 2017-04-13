package main.algorithms;

import main.utils.SwapElementInArray;

import static main.utils.SwapElementInArray.swap;

/**
 * Created by Oscar on 08/04/2017.
 */
public class QuickSort {
    public static <T extends Comparable> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    public static <T extends Comparable> void sort(T[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);

    }

    private static <T extends Comparable> int partition(T[] array, int lo, int hi) {
        int pivot = lo + (hi - lo) / 2;
        SwapElementInArray.swap(array, pivot, hi);
        int storeIndex = lo;
        for (int i = lo; i < hi; i++) {
            if (array[i].compareTo(array[hi]) < 1) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        SwapElementInArray.swap(array, hi, storeIndex);
        return storeIndex;
    }


}
