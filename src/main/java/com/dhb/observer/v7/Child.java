package com.dhb.observer.v7;

import java.util.ArrayList;
import java.util.List;

public class Child {

	private boolean cry = false;

	private List<Observer> observers = new ArrayList<>();
	{
		observers.add(new Dad());
		observers.add(new Mum());
		observers.add(new Dog());
	}


	public boolean isCry() {
		return cry;
	}

	public void weakup() {
		System.out.println("Weak Up: Crying wuwuwuwuwu....");
		cry = true;
		WeakUpEvent event = new WeakUpEvent(System.currentTimeMillis(),"bed",this);
		for(Observer observer : observers) {
			observer.actionOnWeakUp(event);
		}

	}



}
