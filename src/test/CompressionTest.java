package test;

import main.algorithms.compression.LZW;
import main.utils.StopWatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 17/04/2017.
 */
public class CompressionTest {
	private ArrayList<Integer> arrayList;
	private String text;
	private StopWatch stopWatch;

	@BeforeEach
	public void setup() {
		this.arrayList = new ArrayList<>();
		arrayList.add(66);
		arrayList.add(65);
		arrayList.add(256);
		arrayList.add(257);
		arrayList.add(65);
		arrayList.add(65);
		this.text = "BABAABAA";
		this.stopWatch = new StopWatch();
	}

	@Test
	public void testLZWCompress() {
		assertEquals(LZW.compress(text), arrayList);
	}

	@Test
	public void testLZWDecompress() {
		assertEquals(LZW.decompress(this.arrayList), text);
	}

	@AfterEach
	public void elapsedTime() {
		System.out.println(this.stopWatch.toString());
	}
}
