package com.dhb.proxy.v1;


import java.util.Random;
import java.util.concurrent.TimeUnit;

interface Movable{
	void move();
}

public class Tank implements Movable {

	@Override
	public void move() {
		System.out.println("Tank moveing claclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}