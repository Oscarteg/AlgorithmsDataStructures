import algorithms.sorting.BubbleSort;
import algorithms.sorting.HeapSort;
import algorithms.sorting.MergeSort;
import algorithms.sorting.QuickSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Oscar on 08/04/2017.
 */
public class SortingTest {

	private Integer[] array;
	private Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

	@BeforeEach
	public void setup() {
		this.array = new Integer[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	}

	@Test
	public void testBubbleSort() {
		BubbleSort.sortSimple(this.array);
		assertArrayEquals(this.sortedArray, this.array);
	}

	@Test
	public void testQuickSort() {
		QuickSort.sort(this.array);
		assertArrayEquals(this.sortedArray, this.array);
	}

	@Test
	public void testMergeSort() {
		MergeSort.sort(this.array);
		assertArrayEquals(this.sortedArray, this.array);
	}

	@Test
	public void testHeapSort() {
		int[] array = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		HeapSort hs = new HeapSort();
		hs.sort(array);
		assertArrayEquals(sortedArray, array);
	}

}
