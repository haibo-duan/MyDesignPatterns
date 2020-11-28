package com.dhb.iterator.v7;

public class LinkedList<E> implements Collection_<E> {
	Node head = null;
	Node tail = null;

	private int size = 0;

	@Override
	public Iterator_ iterator() {
		return new LinkedListIterator();
	}

	@Override
	public void add(E o) {
		Node n = new Node(o);
		n.next = null;

		if (head == null) {
			head = n;
			tail = n;
		}
		tail.next = n;
		tail = n;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node<E> {
		Node<E> next;
		private E o;

		public Node(E o) {
			this.o = o;
		}

	}

	class LinkedListIterator  implements Iterator_ {

		private Node<E> current = head;
		@Override
		public boolean hasNext() {
			if(current != null) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			Node<E> result = current;
			current = current.next;
			return result.o;
		}
	}
}
