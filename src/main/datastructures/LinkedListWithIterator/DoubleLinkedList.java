package main.datastructures.LinkedListWithIterator;

import main.utils.interfaces.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements List {
	private Entry header;
	private int size;

	public DoubleLinkedList() {
		header = new Entry(null, null, null);
		header.next = header;
		header.previous = header;
	}

	public void addFirst(Object o) {
		addBefore(o, header.next);
	}

	private void addBefore(Object object, Entry entry) {
		Entry newEntry = new Entry(object, entry, entry.previous);
		newEntry.previous.next = newEntry;
		newEntry.next.previous = newEntry;
		size++;
	}

	public Object getFirst() {
		System.out.println(header.element + "\n");
		return header.next.element;
	}

	public Object removeFirst() {
		Entry deleted = header.next;
		remove(header.next);
		return deleted.element;
	}

	@Override
	public void addLast(Object object) {
//		addAfter(object, header.previous); TODO
	}

	private void addAfter(Object object, Entry entry) {
		// TODO
	}

	public Object getLast() {
		return header.previous.element;
	}

	@Override
	public Object removeLast() {
		return null;
	}

	public int size() {
		return size;
	}

	public void clear() {
		Entry e = header.next;
		while (e != header) {
			Entry next = e.next;
			e.next = e.previous = null;
			e.element = null;
			e = next;
		}
		header.next = header.previous = header;
		size = 0;
	}

	public Iterator iterator() {
		return new LItr();
	}

	private void remove(Entry e) {
		if (e == header) {
			throw new NoSuchElementException("Kan Entry niet verwijderen: is header");
		}

		e.previous.next = e.next;
		e.next.previous = e.previous;
		size--;
	}

	private class LItr implements Iterator {
		private Entry pos = header;

		public boolean hasNext() {
			return pos.next != header;
		}

		public Object next() {
			pos = pos.next;
			return pos.element;
		}

		public boolean hasPrevious() {
			return pos.previous != header;
		}

		public Object previous() {
			pos = pos.previous;
			return pos.element;
		}
	}

	private class Entry {
		Object element;
		Entry next;
		Entry previous;

		Entry(Object element, Entry next, Entry previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

}