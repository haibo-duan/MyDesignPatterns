package com.dhb.observer.v5;

public class Mum implements Observer{

	@Override
	public void actionOnWeakUp() {
		this.hug();
	}

	public void hug() {
		System.out.println("mum huging ... ");
	}
}
