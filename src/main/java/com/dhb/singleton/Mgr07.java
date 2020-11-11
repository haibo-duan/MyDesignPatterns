package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例  采用静态内部类实现
 */
public class Mgr07 {

	private static Mgr07 INSTANCE;

	private static class Mgr07Holder{
		private static final Mgr07 INSTANCE = new Mgr07();
	}
	private Mgr07() {}

	public static Mgr07 getInstance() {
		return Mgr07Holder.INSTANCE;
	}

	public static void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr07.getInstance().hashCode())).start();
		});
	}
}
