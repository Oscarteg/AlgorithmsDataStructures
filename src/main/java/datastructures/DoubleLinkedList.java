package datastructures;

import java.util.NoSuchElementException;

/**
 * Created by Oscar on 08/04/2017.
 */
public class DoubleLinkedList<E> {
	int size;
	private Node head; // the first element
	private Node tail; // the last element

	public void add(E element) {
		if (element == null) {
			throw new AssertionError();
		}

		// tail and head are the same node when list has only one item
		if (head == null) {
			head = tail = new Node(element);
		} else {
			//assign new node to next of tail and make tail the last element
			tail.next = new Node(element, tail, null);
			tail = tail.next;
		}
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public E get(int index) {
		if (index >= size && index < 0) {
			throw new NoSuchElementException();
		}

		// find element at given index
		Node node = head;
		for (int i = 0; i < index; i++)
			node = node.next;

		return node.elem;
	}

	public boolean delete(E element) {
		Node temp = head;
		while (temp != null && !temp.elem.equals(element)) {
			temp = temp.next;
		}
		// no node with given element is found
		if (temp == null) {
			return false;
		}

		size--;

		// if found node is head of the list, need to change to next element
		if (temp == head) {
			head = head.next;
			return true;
		}

		// if found node is last node of the list, need to change tail
		if (temp == tail) {
			tail = temp.prev;
			return true;
		}

		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		return true;
	}

	private class Node {
		E elem;
		Node next;
		Node prev;

		public Node(E elem) {
			this.elem = elem;
		}

		public Node(E elem, Node prev, Node next) {
			this.elem = elem;
			this.next = next;
			this.prev = prev;
		}
	}
}