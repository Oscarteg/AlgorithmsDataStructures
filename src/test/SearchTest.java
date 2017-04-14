package test;

import main.algorithms.BinarySearch;
import main.utils.StopWatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 13/04/2017.
 */
public class SearchTest {
	private Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
	private StopWatch stopWatch;

	@BeforeEach
	public void setup() {
		this.stopWatch = new StopWatch();
	}

	@Test
	public void testBinarySearch() {
		assertEquals(BinarySearch.search(this.array, 6), 5);

	}

	@AfterEach
	public void elapsedTime() {
		this.stopWatch.toString();
	}
}
