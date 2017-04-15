package main.utils.interfaces;

import java.util.Iterator;

/**
 * Created by Oscar on 15/04/2017.
 */

public interface List<E> {
	void addFirst(Object o);

	Object getFirst();

	Object removeFirst();

	void addLast(Object o);

	Object getLast();

	Object removeLast();

	Iterator iterator();

	int size();

	void clear();
}