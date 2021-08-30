package com.dhb.observer.v8;

public class Dog implements Observer {

	@Override
	public void actionOnWeakUp(WeakUpEvent event) {
		this.wang();
	}

	public void wang() {
		System.out.println("dog wang...");
	}
}
