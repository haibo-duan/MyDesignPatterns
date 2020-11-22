package com.dhb.observer.v6;

public class Dog implements Observer {

	@Override
	public void actionOnWeakUp(WeakUpEvent event) {
		this.wang();
	}

	public void wang() {
		System.out.println("dog wang...");
	}
}
