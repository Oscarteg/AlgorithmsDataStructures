package datastructures;

import datastructures.LinkedListWithIterator.DoubleLinkedList;
import utils.interfaces.Stack;


/**
 * Created by Oscar on 08/04/2017.
 */

public class StackUsingLinkedList implements Stack {
	private DoubleLinkedList lijst;

	public StackUsingLinkedList() {
		lijst = new DoubleLinkedList();
	}

	@Override
	public void push(Object o) {
		lijst.addLast(o);
	}

	@Override
	public Object pop() {
		return lijst.removeLast();
	}

	@Override
	public Object peek() {
		return lijst.getLast();
	}

	@Override
	public int size() {
		return lijst.size();
	}

	@Override
	public boolean isEmpty() {
		return (lijst.size() == 0);
	}

	@Override
	public void makeEmpty() {

	}
}
