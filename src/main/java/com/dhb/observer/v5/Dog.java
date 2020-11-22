package com.dhb.observer.v5;

public class Dog implements Observer{

	@Override
	public void actionOnWeakUp() {
		this.wang();
	}

	public void wang() {
		System.out.println("dog wang...");
	}
}
