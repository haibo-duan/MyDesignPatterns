package com.dhb.observer.v7;

public class WeakUpEvent {

	long timestamp;
	String loc;
	Child source;

	public WeakUpEvent(long timestamp, String loc,Child source) {
		this.timestamp = timestamp;
		this.loc = loc;
		this.source = source;
	}
}
