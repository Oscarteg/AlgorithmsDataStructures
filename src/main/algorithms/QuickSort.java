package main.algorithms;

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

    private static <T extends Comparable> int partition(T[] a, int lo, int hi) {
        int pivot = lo + (hi - lo) / 2;
        swap(a, pivot, hi);
        int storeIndex = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i].compareTo(a[hi]) < 1) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, hi, storeIndex);
        return storeIndex;
    }

    private static <T extends Comparable> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
