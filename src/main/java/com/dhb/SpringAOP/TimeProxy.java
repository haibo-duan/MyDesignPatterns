package com.dhb.SpringAOP;

public class TimeProxy {

	public void before() {
		System.out.println("metnod start ... "+System.currentTimeMillis());
	}

	public void after() {
		System.out.println("method stop ... "+System.currentTimeMillis());
	}


}
