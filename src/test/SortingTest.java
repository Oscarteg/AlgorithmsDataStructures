package test;

import jdk.nashorn.internal.ir.annotations.Ignore;
import main.algorithms.sorting.BubbleSort;
import main.algorithms.sorting.HeapSort;
import main.algorithms.sorting.MergeSort;
import main.algorithms.sorting.QuickSort;
import main.utils.StopWatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Oscar on 08/04/2017.
 */
public class SortingTest {

	private StopWatch stopWatch;
	private Integer[] array;
	private Integer[] sortedArray = {2, 5, 6, 7, 8};
//    private Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

	@BeforeEach
	public void setup() {
		stopWatch = new StopWatch();
		this.array = new Integer[]{8, 6, 2, 7, 5};
//        this.array = new Integer[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
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

	@Ignore
	@Test
	public void testMergeSort() {
		MergeSort.sort(this.array);
		assertArrayEquals(this.sortedArray, this.array);
	}

	@Ignore
	@Test
	public void testHeapSort() {
		int[] array = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
		int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		HeapSort hs = new HeapSort();
		hs.sort(array);
		assertArrayEquals(sortedArray, array);
	}

	@AfterEach
	public void time() {
		System.out.println("It took " + this.stopWatch.getElapsedTime());

	}

}
