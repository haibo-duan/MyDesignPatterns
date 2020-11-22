package com.dhb.observer.v2;

public class Child {

	private boolean cry = false;

	public boolean isCry() {
		return cry;
	}

	public void weakup() {
		System.out.println("Weak Up: Crying wuwuwuwuwu....");
		cry = true;
	}



}
