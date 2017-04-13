package main.algorithms;

import static main.utils.SwapElementInArray.swap;

/**
 * Created by Oscar on 08/04/2017.
 */
public class QuickSort {
    public static <T extends Comparable> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable> void quickSort(T[] array, int positionLeft, int positionRight) {
        if (positionLeft >= positionRight) {
            return;
        }

        T pivotValue = array[positionRight];
        int wall = positionLeft;

        for (int currentPosition = positionLeft; currentPosition < positionRight; currentPosition++) {
            if (pivotValue.compareTo(array[currentPosition]) > 0) {
                swap(array, currentPosition, wall);
                wall++;
            }
        }

        swap(array, positionRight, wall);
        quickSort(array, positionLeft, wall - 1);
        quickSort(array, wall, positionRight);
    }

}
