package com.dhb.iterator.v1;

class ArrayList{
	Object[] objects =  new Object[10];

	private int index = 0;

	public void add(Object o) {
		if(index == objects.length -1) {
			Object[] newObjects = new Object[objects.length*2];
			System.arraycopy(objects,0,newObjects,0,objects.length);
			objects = newObjects;
		}
		objects[index] = o;
		index ++;
	}

	public int size() {
		return index;
	}
}

class Main{
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		for(int i=0;i<15;i++) {
			list.add(new String("s"+1));
		}
		System.out.println(list.size());
	}
}

