package test.java;

import main.java.algorithms.search.BinarySearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 13/04/2017.
 */
public class SearchTest {
	private Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testLinearSearch() {

	}

	@Test
	public void testBinarySearch() {
		assertEquals(BinarySearch.search(this.array, 6), 5);
	}

}
