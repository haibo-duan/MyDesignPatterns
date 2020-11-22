package com.dhb.observer.v2;


import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Child chid = new Child();

		while (!chid.isCry()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("observing ......");
		}

	}
}
