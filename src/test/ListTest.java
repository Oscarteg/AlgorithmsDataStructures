package test;

import jdk.nashorn.internal.ir.annotations.Ignore;
import main.datastructures.LinkedListWithIterator.List;
import main.datastructures.LinkedListWithIterator.ListIterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 09/06/2016.
 */

// TODO doesn't work yet.

public class ListTest {
	private List list;
	private ListIterator listIterator;

	@BeforeEach
	public void setup() {
		list = new List();
		listIterator = new ListIterator();
	}

	@Ignore
	@Test
	public void test_remove_first() {
		list.addFirst("Een");
		list.addFirst("Twee");
		assertEquals(list.removeFirst(), "Twee");
		assertEquals(list.size(), 1);
	}


	@Ignore
	@Test
	public void test_add_first() {
		list.addFirst("Een");
		list.addFirst("Twee");
		list.addFirst("Drie");
		list.addFirst("Laatste");
		int i = 0;
		Object[] objecten = {"Laatste", "Drie", "Twee", "Een"};
		while (listIterator.hasNext()) {
			Object o = listIterator.next();
			assertEquals(objecten[i], o);
			i++;
		}
	}

	@Ignore
	@Test
	public void test_add_last() {
		list.addLast("EenNaLaatste");
		list.addFirst("Eerste");
		list.addLast("Laatste");
		int i = 0;
		Object[] objecten = {"Eerste", "EenNaLaatste", "Laatste"};
	}

	@Ignore
	@AfterEach
	public void teardown() {
		list.clear();
	}


}
