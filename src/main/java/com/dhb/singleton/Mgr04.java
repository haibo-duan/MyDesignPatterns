package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例  在方法上加锁，但是加锁导致效率降低
 */
public class Mgr04 {

	private static  Mgr04 INSTANCE;

	private Mgr04() {}

	public static synchronized Mgr04 getInstance() {
		if(INSTANCE == null) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Mgr04();
		}
		return INSTANCE;
	}

	public static void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
		});
	}
}
