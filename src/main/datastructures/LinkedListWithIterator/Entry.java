package main.datastructures.LinkedListWithIterator;

/**
 * Created by Oscar on 14/04/2017.
 */
public class Entry {
	private Object element;
	private Entry next;
	private Entry previous;

	Entry(Object element, Entry next, Entry previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Entry getNext() {
		return next;
	}

	public void setNext(Entry next) {
		this.next = next;
	}

	public Entry getPrevious() {
		return previous;
	}

	public void setPrevious(Entry previous) {
		this.previous = previous;
	}
}
