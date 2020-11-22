package com.dhb.observer.v4;

public class Child {

	private boolean cry = false;

	private Dad d = new Dad();
	private Mum m = new Mum();
	private Dog dog = new Dog();

	public boolean isCry() {
		return cry;
	}

	public void weakup() {
		System.out.println("Weak Up: Crying wuwuwuwuwu....");
		cry = true;
		d.feed();
		m.hug();
		dog.wang();

	}



}
