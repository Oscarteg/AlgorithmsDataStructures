package main.datastructures.LinkedListWithIterator;

import java.util.Iterator;

public class List {
	private Entry header;
	private int size;

	public List() {
		header = new Entry(null, null, null);
		header.setNext(header);
		header.setPrevious(header);
	}

	public Iterator iterator() {
		return new ListIterator();
	}

	public void addFirst(Object o) {
		addBefore(o, header.getNext());
	}

	public Object getFirst() {
		return header.getNext().getElement();
	}

	public Object removeFirst() {
		Object object = header.getNext().getElement();
		remove(header.getNext());
		return object;
	}

	public void addLast(Object o) {
		addAfter(o);
	}

	public Object getLast() {
		return header.getPrevious().getElement();
	}

	public Object removeLast() {
		Object object = header.getPrevious().getElement();
		remove(header.getPrevious());
		return object;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void clear() {
		header = new Entry(null, null, null);
		header.setNext(header);
		header.setPrevious(header);
		size = 0;

	}

	private void addBefore(Object o, Entry entry) {
		Entry newEntry = new Entry(o, entry, entry.getPrevious());
		newEntry.getPrevious().setNext(newEntry);
		newEntry.getNext().setPrevious(newEntry);
		size++;
	}

	private void addAfter(Object object) {
		Entry lastEntry = new Entry(object, header, header.getPrevious());
		lastEntry.getNext().setPrevious(lastEntry);
		lastEntry.getPrevious().setNext(lastEntry);
		size++;
	}

	private void remove(Entry entry) {
		entry.getNext().setNext(entry.getNext());
		entry.getNext().setPrevious(entry.getPrevious());
		size--;
	}

	public Entry getHeader() {
		return header;
	}

	public void setHeader(Entry header) {
		this.header = header;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

