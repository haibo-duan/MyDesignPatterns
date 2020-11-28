package com.dhb.iterator.v5;

public class LinkedList implements Collection_ {
	Node head = null;
	Node tail = null;

	private int size = 0;

	@Override
	public Iterator_ iterator() {
		return new LinkedListIterator();
	}

	@Override
	public void add(Object o) {
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

	private class Node {
		Node next;
		private Object o;

		public Node(Object o) {
			this.o = o;
		}

	}

	class LinkedListIterator  implements Iterator_ {

		private Node current = head;
		@Override
		public boolean hasNext() {
			if(current != null) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			Node result = current;
			current = current.next;
			return result.o;
		}
	}
}
