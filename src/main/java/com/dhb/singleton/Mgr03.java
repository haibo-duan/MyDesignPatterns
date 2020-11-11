package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例
 * 虽然可以达到按需初始化的目的，但是会带来线程不安全问题
 */
public class Mgr03 {

	private static Mgr03 INSTANCE;

	private Mgr03() {
	}

	public static Mgr03 getInstance() {
		if (INSTANCE == null) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			INSTANCE = new Mgr03();
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
		});
	}

	public void m() {
		System.out.println("m");
	}
}
