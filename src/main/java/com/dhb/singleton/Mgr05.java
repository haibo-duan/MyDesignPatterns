package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例  将synchronized加到需要的代码块上 这样不能解决问题
 */
public class Mgr05 {

	private static Mgr05 INSTANCE;

	private Mgr05() {}

	public static  Mgr05 getInstance() {
		//如果加锁在判断内部，那么可能导致判不能解决这个问题
		if(INSTANCE == null) {
			synchronized (Mgr05.class) {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				INSTANCE = new Mgr05();
			}
		}
		return INSTANCE;
	}

	public static void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
		});
	}
}
