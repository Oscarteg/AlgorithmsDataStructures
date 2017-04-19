package utils;

/**
 * Created by Oscar on 08/04/2017.
 */
final public class Entry {

	private Object element;
	private Entry next = null;
	private Entry previous = null;

	public Entry(Object element) {
		this.element = element;
	}

	public Entry() {
	}

	public Object getElement() {
		return element;
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
