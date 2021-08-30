package com.dhb.observer.v8;

public class WeakUpEvent extends Event<Child>{

	long timestamp;
	String loc;
	Child source;

	public WeakUpEvent(long timestamp, String loc, Child source) {
		this.timestamp = timestamp;
		this.loc = loc;
		this.source = source;
	}

	@Override
	Child getResource() {
		return source;
	}
}
