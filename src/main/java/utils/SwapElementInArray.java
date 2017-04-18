package main.java.utils;

/**
 * Created by Oscar on 08/04/2017.
 */
public class SwapElementInArray {
	public static <T> void swap(T[] array, int left, int right) {
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
