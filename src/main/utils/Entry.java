package main.utils;

/**
 * Created by Oscar on 08/04/2017.
 */
public class Entry {
    Object element;
    Entry next;
    Entry previous;

    Entry(Object element, Entry next, Entry previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }
}
