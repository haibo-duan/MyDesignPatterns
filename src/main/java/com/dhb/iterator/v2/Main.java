package com.dhb.iterator.v2;



class LinkedList{
	Node head = null;
	Node tail = null;

	private int size = 0;


	public void add(Object o) {
		Node n = new Node(o);
		n.next = null;

		if(head == null) {
			head = n;
			tail = n;
		}
		tail.next = n;
		tail = n;
		size ++;
	}

	public int size() {
		return size;
	}

	private class Node{
		private Object o;
		Node next;

		public Node(Object o) {
			this.o = o;
		}
	}
}

class Main{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for(int i=0;i<15;i++) {
			list.add(new String("s"+1));
		}
		System.out.println(list.size());
	}
}

