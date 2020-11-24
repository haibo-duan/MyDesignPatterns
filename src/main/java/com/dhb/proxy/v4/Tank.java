package com.dhb.proxy.v4;


import java.util.Random;
import java.util.concurrent.TimeUnit;

interface Movable{
	void move();
}

public class Tank implements Movable {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moveing claclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main(String[] args) {
		new Tank2().move();
	}
}

class Tank2 extends Tank {
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moveing claclacla...");
		super.move();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}