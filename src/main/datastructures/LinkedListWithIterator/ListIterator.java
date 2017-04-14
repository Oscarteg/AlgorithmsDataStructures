package main.datastructures.LinkedListWithIterator;

import java.util.Iterator;

/**
 * Created by Oscar on 14/04/2017.
 */
public class ListIterator implements Iterator {
	private Entry pos;

	public boolean hasNext() {
		return pos.getNext() != null;
	}

	public Object next() {
		pos = pos.getNext();
		return pos.getElement();
	}

	public boolean hasPrevious() {
		return pos.getPrevious() != null;
	}

	public Object previous() {
		pos = pos.getPrevious();
		return pos.getElement();
	}
}
