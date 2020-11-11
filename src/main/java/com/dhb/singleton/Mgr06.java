package com.dhb.singleton;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 懒汉式单例  将synchronized加到需要的代码块上 通过双重检查机制来实现单例 能实现，但是存在可见性问题
 */
public class Mgr06 {

	private static Mgr06 INSTANCE;

	private Mgr06() {}

	public static Mgr06 getInstance() {
		//双重检查 第一次判断不能省去 可以拦截大部分无用调用
		if(INSTANCE == null) {
			synchronized (Mgr06.class) {
				if(INSTANCE == null) {
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Mgr06();
				}
			}
		}
		return INSTANCE;
	}

	public static void m(){
		System.out.println("m");
	}

	public static void main(String[] args) {
		IntStream.range(0, 100).forEach((i) -> {
			new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
		});
	}
}
