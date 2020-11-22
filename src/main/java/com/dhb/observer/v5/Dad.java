package com.dhb.observer.v5;

public class Dad implements Observer{

	@Override
	public void actionOnWeakUp() {
		this.feed();
	}

	public void feed() {
		System.out.println("dad feeding ...");
	}
}
