package main.algorithms.search;

/**
 * Created by Oscar on 08/04/2017.
 */
public class LinearSearch {
	public static int searchIndex(int list[], int search) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] == search) {
				return i;
			}
		}
		return 0;
	}

}
