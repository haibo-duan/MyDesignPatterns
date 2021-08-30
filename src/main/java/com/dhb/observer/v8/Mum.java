package com.dhb.observer.v8;

public class Mum implements Observer {

	@Override
	public void actionOnWeakUp(WeakUpEvent event) {
		this.hug();
	}

	public void hug() {
		System.out.println("mum huging ... ");
	}
}
