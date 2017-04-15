package test;

import main.datastructures.LinkedListWithIterator.DoubleLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 09/06/2016.
 */

public class DoubleLinkedListTest {
	private DoubleLinkedList list;
	private Iterator iterator;

	@BeforeEach
	public void setup() {
		list = new DoubleLinkedList();
		iterator = list.iterator();
	}

	@Test
	public void test_remove_first() {
		list.addFirst("Een");
		list.addFirst("Twee");
		assertEquals(list.removeFirst(), "Twee");
		assertEquals(list.size(), 1);
	}

	@Test
	public void test_add_first() {
		list.addFirst("Een");
		list.addFirst("Twee");
		list.addFirst("Drie");
		list.addFirst("Laatste");
		Object[] objecten = {"Laatste", "Drie", "Twee", "Een"};
		this.testList(objecten);

	}

	@Disabled("not ready yet, fix todos first")
	@Test
	public void test_add_last() {
		list.addFirst("EenNaLaatste");
		list.addFirst("Eerste");
		list.addFirst("Laatste");
		Object[] objecten = {"Laatste", "Eerste", "EenNaLaatste"};
		this.testList(objecten);

	}

	@AfterEach
	public void teardown() {
		list.clear();
	}

	private void testList(Object[] objects) {
		int i = 0;
		while (iterator.hasNext()) {
			Object o = iterator.next();
			assertEquals(objects[i], o);
			i++;
		}
	}


}
