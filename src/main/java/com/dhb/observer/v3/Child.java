package com.dhb.observer.v3;

public class Child {

	private boolean cry = false;

	private Dad d = new Dad();

	public boolean isCry() {
		return cry;
	}

	public void weakup() {
		System.out.println("Weak Up: Crying wuwuwuwuwu....");
		cry = true;
		d.feed();
	}



}
