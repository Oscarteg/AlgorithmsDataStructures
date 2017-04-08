package test;

import jdk.nashorn.internal.ir.annotations.Ignore;
import main.algorithms.BubbleSort;
import main.algorithms.HeapSort;
import main.algorithms.MergeSort;
import main.algorithms.QuickSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by Oscar on 08/04/2017.
 */
public class SortingTest {


    private Integer[] array;
    private long startTime;
    private Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

    @BeforeEach
    public void setup() {
        this.startTime = System.nanoTime();
        this.array = new Integer[]{8, 7, 6, 5, 4, 3, 2, 1};
    }

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(this.array);
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

    @Ignore
    @Test
    public void testHeapSort() {
        HeapSort ms = new HeapSort();
//        ms.heapSort(this.array);
        assertArrayEquals(this.sortedArray, this.array);
    }

    @AfterEach
    public void time() {
        System.out.println("It took " + (System.nanoTime() - startTime));

    }

    private void printArray(int[] list) {
        for (int aList : list) {
            System.out.print(aList + " ");
        }
        System.out.println();
    }


}
