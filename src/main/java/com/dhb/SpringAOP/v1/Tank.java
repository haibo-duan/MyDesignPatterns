package com.dhb.SpringAOP.v1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tank {

	public void move() {
		System.out.println("tank moving claclaclacla...");
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
